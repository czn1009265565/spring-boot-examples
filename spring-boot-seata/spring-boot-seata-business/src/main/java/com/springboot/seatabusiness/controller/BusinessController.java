package com.springboot.seatabusiness.controller;

import com.springboot.seatabusiness.client.OrderClient;
import com.springboot.seatabusiness.client.ProductClient;
import com.springboot.seatabusiness.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zenan
 * @date: 2021/5/31
 */
@RestController
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping(value = "purchase")
    public Boolean purchase(@RequestParam(value = "productId") Long productId) {
        businessService.purchase(productId);
        return true;
    }
}
