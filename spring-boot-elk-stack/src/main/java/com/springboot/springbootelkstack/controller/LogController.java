package com.springboot.springbootelkstack.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zenan
 * @date: 2021/3/26
 */
@Slf4j
@RestController
public class LogController {
    @GetMapping
    public String log() {
        log.info("this is test log!");
        return "success";
    }
}
