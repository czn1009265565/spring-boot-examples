package com.springboot.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: zenan
 * @date: 2021/4/7
 */
@Controller
public class ClientController {
    @GetMapping
    public String index() {
        return "client";
    }
}
