package com.springboot.shardingtable.service;

import com.springboot.shardingtable.entity.User;

import java.util.List;

/**
 * @author: zenan
 * @date: 2021/3/23
 */
public interface UserService {
    int create(User user);

    User findById(Integer userId);

    User findByUsername(String username);

    List<User> list();
}
