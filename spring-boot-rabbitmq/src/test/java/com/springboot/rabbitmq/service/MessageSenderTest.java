package com.springboot.rabbitmq.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: zenan
 * @date: 2021/5/18
 */
@SpringBootTest
class MessageSenderTest {
    @Autowired
    private MessageSender messageSender;

    @Test
    void send() {
        messageSender.send();
    }
}