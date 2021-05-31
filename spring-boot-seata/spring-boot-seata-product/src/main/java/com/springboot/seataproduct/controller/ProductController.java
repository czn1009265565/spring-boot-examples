package com.springboot.seataproduct.controller;

import com.springboot.seataproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zenan
 * @date: 2021/5/23
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping(value = "/deduct")
    public Boolean deduct(@RequestParam(value = "productId") Long productId,
                          @RequestParam(value = "count") Integer count) {
        productService.deduct(productId, count);
        return true;
    }
}
