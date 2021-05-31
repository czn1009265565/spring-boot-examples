package com.springboot.seataorder.controller;

import com.springboot.seataorder.entity.Order;
import com.springboot.seataorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zenan
 * @date: 2021/5/26
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/create")
    public Boolean create(@RequestParam(value = "productId") Long productId) {
        // 新建order
        orderService.create(productId);
        return true;
    }
}
