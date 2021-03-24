package com.springboot.shardingreadwrite.service;

import com.springboot.shardingreadwrite.entity.User;

import java.util.List;

/**
 * @author: zenan
 * @date: 2021/3/23
 */
public interface UserService {
    int create(User user);

    User findById(Long userId);

    User findByUsername(String username);

    List<User> list();
}
