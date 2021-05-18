package com.springboot.rabbitmq.service;

import com.springboot.rabbitmq.config.RabbitMqConfig;
import com.springboot.rabbitmq.dto.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zenan
 * @date: 2021/5/18
 */
@Service
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        rabbitTemplate.convertAndSend(RabbitMqConfig.TOPIC_EXCHANGE,
                RabbitMqConfig.TOPIC_QUEUE, new Message(0, "zero"));
    }
}
