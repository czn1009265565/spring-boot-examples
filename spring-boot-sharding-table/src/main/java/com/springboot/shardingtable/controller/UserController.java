package com.springboot.shardingtable.controller;

import com.springboot.shardingtable.entity.User;
import com.springboot.shardingtable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: zenan
 * @date: 2021/3/23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String create(@RequestBody User user) {
        userService.create(user);
        return "success";
    }

    @GetMapping("/{userId}")
    public User detail(@PathVariable("userId") Integer userId) {
        return userService.findById(userId);
    }

    @GetMapping("/query")
    public User query(String username) {
        return userService.findByUsername(username);
    }

    @GetMapping
    public List<User> list() {
        return userService.list();
    }

}
