package com.springboot.elasticsearch.service;

import com.springboot.elasticsearch.dao.EsProductRespository;
import com.springboot.elasticsearch.entity.EsProduct;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: zenan
 * @date: 2021/4/15
 */
@Slf4j
@Service
public class EsProductServiceImpl implements EsProductService{

    @Autowired
    private EsProductRespository esProductRespository;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public EsProduct create(Long id) {
        // MySQL findById
        EsProduct esProduct = new EsProduct(123456789L, 1L, "联想", "Air14", "高性能,轻薄本", new BigDecimal("4499"));
        return esProductRespository.save(esProduct);
    }

    @Override
    public void delete(Long id) {
        esProductRespository.deleteById(id);
    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return esProductRespository.findByNameOrDescription(keyword, keyword, pageable);
    }

    @Override
    public Page<EsProduct> search(Integer brandId, String keyword, Integer pageNum, Integer pageSize, Integer sort) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        // 分页
        nativeSearchQueryBuilder.withPageable(pageable);

        // 过滤
        if (brandId != null) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            boolQueryBuilder.must(QueryBuilders.termQuery("brandId", brandId));
            // 续加条件...
            nativeSearchQueryBuilder.withFilter(boolQueryBuilder);
        }

        // 搜索
        if (StringUtils.hasLength(keyword)) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            boolQueryBuilder.should(QueryBuilders.matchQuery("name", keyword));
            boolQueryBuilder.should(QueryBuilders.matchQuery("description", keyword));
            nativeSearchQueryBuilder.withQuery(boolQueryBuilder);
        } else {
            nativeSearchQueryBuilder.withQuery(QueryBuilders.matchAllQuery());
        }

        // 排序
        if (sort == null) {
            nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC));
        }

        NativeSearchQuery searchQuery = nativeSearchQueryBuilder.build();
        SearchHits<EsProduct> searchHits = elasticsearchRestTemplate.search(searchQuery, EsProduct.class);
        List<EsProduct> searchProductList = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
        return new PageImpl<>(searchProductList,pageable,searchHits.getTotalHits());
    }
}
