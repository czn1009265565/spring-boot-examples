package com.springboot.springbootgitlabcicd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zenan
 * @date: 2021/3/25
 */
@RestController
public class TestController {
    @GetMapping
    public String test() {
        return "success";
    }
}
