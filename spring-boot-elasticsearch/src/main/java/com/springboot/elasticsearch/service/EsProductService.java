package com.springboot.elasticsearch.service;

import com.springboot.elasticsearch.entity.EsProduct;
import org.springframework.data.domain.Page;

/**
 * @author: zenan
 * @date: 2021/4/14
 */
public interface EsProductService {
    /**
     * 根据id创建商品
     * @param id
     * @return
     */
    EsProduct create(Long id);

    /**
     * 根据id删除商品
     * @param id
     */
    void delete(Long id);

    /**
     * 简单搜索(根据关键词搜索名称或描述)
     * @param keyword 关键词
     * @param pageNum 页码
     * @param pageSize 页容量
     * @return Page<EsProduct>
     */
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 复合查询
     * @param brandId 品牌Id
     * @param keyword 关键词
     * @param pageNum 页码
     * @param pageSize 页容量
     * @param sort 排序方式
     * @return Page<EsProduct>
     */
    Page<EsProduct> search(Integer brandId, String keyword, Integer pageNum, Integer pageSize, Integer sort);
}
