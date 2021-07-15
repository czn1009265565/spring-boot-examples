package com.springboot.multipledatatransaction.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author: zenan
 * @date: 2021/7/15
 */
public interface TripService {
    /**
     * 创建行程
     * 测试多数据源的事务ACID
     *
     * 结论:
     * `@Transactional` 事务管理器只能二者选其一
     * Mysql 事务管理器(默认)
     * Mongodb 事务管理器
     */
    @Transactional
    void create();
}
