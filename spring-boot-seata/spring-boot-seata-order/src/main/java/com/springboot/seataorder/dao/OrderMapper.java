package com.springboot.seataorder.dao;

import com.springboot.seataorder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: zenan
 * @date: 2021/5/31
 */
public interface OrderMapper extends JpaRepository<Order, Long> {
}
