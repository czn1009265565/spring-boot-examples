package com.springboot.elasticsearch.controller;

import com.springboot.elasticsearch.common.PageResult;
import com.springboot.elasticsearch.common.ResponseResult;
import com.springboot.elasticsearch.entity.EsProduct;
import com.springboot.elasticsearch.service.EsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zenan
 * @date: 2021/4/15
 */
@RestController
@RequestMapping("/esProduct")
public class EsProductController {

    @Autowired
    private EsProductService esProductService;

    @PostMapping("/{id}")
    public ResponseResult<EsProduct> create(@PathVariable("id") Long id) {
        EsProduct esProduct = esProductService.create(id);
        if (esProduct == null) {
            return ResponseResult.failed(null);
        }
        return ResponseResult.success(esProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseResult<Object> delete(@PathVariable("id") Long id) {
        esProductService.delete(id);
        return ResponseResult.success(null);
    }

    @GetMapping
    public ResponseResult<PageResult<EsProduct>> search(@RequestParam("keyword") String keyword,
                                                        @RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        Page<EsProduct> page = esProductService.search(keyword, pageNum, pageSize);
        return ResponseResult.success(PageResult.restPage(page));
    }

    @GetMapping("/mul")
    public ResponseResult<PageResult<EsProduct>> search(
            @RequestParam(value = "brandId", required = false) Integer brandId,
            @RequestParam("keyword") String keyword,
            @RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "sort", required = false) Integer sort
    ) {
        Page<EsProduct> page = esProductService.search(brandId, keyword, pageNum, pageSize, sort);
        return ResponseResult.success(PageResult.restPage(page));
    }
}
