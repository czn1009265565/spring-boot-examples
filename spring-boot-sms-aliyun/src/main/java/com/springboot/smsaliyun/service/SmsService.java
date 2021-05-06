package com.springboot.smsaliyun.service;

import com.springboot.smsaliyun.dto.SmsMessage;

/**
 * @author: zenan
 * @date: 2021/5/6
 */
public interface SmsService {
    /**
     * 发送短信
     * @param smsMessage 消息
     */
    void send(SmsMessage smsMessage);
}
