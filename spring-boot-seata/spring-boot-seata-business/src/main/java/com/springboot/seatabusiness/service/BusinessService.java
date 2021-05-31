package com.springboot.seatabusiness.service;

import com.springboot.seatabusiness.client.OrderClient;
import com.springboot.seatabusiness.client.ProductClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zenan
 * @date: 2021/5/31
 */
@Service
public class BusinessService {

    @Autowired
    private OrderClient orderClient;

    @Autowired
    private ProductClient productClient;

    @GlobalTransactional
    public void purchase(Long productId) {
        // 创建订单
        orderClient.create(productId);

        // 扣除库存
        productClient.deduct(productId, 1);
    }
}
