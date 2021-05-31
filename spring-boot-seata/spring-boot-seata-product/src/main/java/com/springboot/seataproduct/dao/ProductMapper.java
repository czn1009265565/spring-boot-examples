package com.springboot.seataproduct.dao;

import com.springboot.seataproduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: zenan
 * @date: 2021/5/23
 */
public interface ProductMapper extends JpaRepository<Product, Long> {
}
