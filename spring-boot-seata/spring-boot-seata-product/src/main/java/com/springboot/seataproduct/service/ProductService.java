package com.springboot.seataproduct.service;

import com.springboot.seataproduct.dao.ProductMapper;
import com.springboot.seataproduct.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: zenan
 * @date: 2021/5/23
 */
@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public void deduct(Long productId, Integer count) {
        Optional<Product> productOptional =  productMapper.findById(productId);
        if (!productOptional.isPresent()) {
            throw new RuntimeException("当前productId不存在");
        }

        Product product = productOptional.get();
        product.setCount(product.getCount() - count);
        productMapper.save(product);
    }
}
