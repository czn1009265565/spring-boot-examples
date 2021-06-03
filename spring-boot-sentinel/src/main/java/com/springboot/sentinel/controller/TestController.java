package com.springboot.sentinel.controller;

import org.apache.tomcat.jni.Time;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zenan
 * @date: 2021/6/3
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test() throws InterruptedException {
        Thread.sleep(1000L);
        return "success";
    }
}
