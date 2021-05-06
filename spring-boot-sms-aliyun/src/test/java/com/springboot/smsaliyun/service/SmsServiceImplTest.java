package com.springboot.smsaliyun.service;

import com.springboot.smsaliyun.dto.SmsMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: zenan
 * @date: 2021/5/6
 */
@SpringBootTest
class SmsServiceImplTest {

    @Autowired
    private SmsService smsService;

    @Test
    void send() {
        SmsMessage smsMessage = new SmsMessage();
        smsMessage.setReceiver("17858804263");
        smsMessage.setSmsCode("8888");
        smsService.send(smsMessage);
    }
}