package com.springboot.seatabusiness.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: zenan
 * @date: 2021/5/31
 */
@FeignClient(name = "order", url = "http://127.0.0.1:8081")
public interface OrderClient {

    @GetMapping(value = "/order/create")
    Boolean create(@RequestParam(value = "productId") Long productId);
}
