package com.springboot.rabbitmq.dto;

import lombok.Data;

/**
 * @author: zenan
 * @date: 2021/5/18
 */
@Data
public class Message {
    private Integer code;

    private String desc;

    public Message() {
    }

    public Message(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
