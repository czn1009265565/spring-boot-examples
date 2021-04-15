package com.springboot.elasticsearch.dao;

import com.springboot.elasticsearch.entity.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author: zenan
 * @date: 2021/4/14
 */
public interface EsProductRespository extends ElasticsearchRepository<EsProduct, Long> {

    Page<EsProduct> findByNameOrDescription(String name, String description, Pageable pageable);

}
