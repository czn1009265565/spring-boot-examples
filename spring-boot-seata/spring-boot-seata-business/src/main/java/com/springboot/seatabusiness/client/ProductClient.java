package com.springboot.seatabusiness.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: zenan
 * @date: 2021/5/31
 */
@FeignClient(url = "http://127.0.0.1:8080", name = "product")
public interface ProductClient {

    @GetMapping(value = "/product/deduct")
    Boolean deduct(@RequestParam(value = "productId") Long productId,
                   @RequestParam(value = "count") Integer count);
}
