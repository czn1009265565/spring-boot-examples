package com.springboot.seataorder.service;

import com.springboot.seataorder.dao.OrderMapper;
import com.springboot.seataorder.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author: zenan
 * @date: 2021/5/23
 */
@Slf4j
@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    public Order create(Long productId) {
        Order order = new Order();
        order.setOrderId(System.currentTimeMillis());
        order.setProductId(productId);
        order.setCreateTime(LocalDateTime.now());
        return orderMapper.save(order);
    }
}
