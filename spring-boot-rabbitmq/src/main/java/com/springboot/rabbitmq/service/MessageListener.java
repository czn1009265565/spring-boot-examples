package com.springboot.rabbitmq.service;

import com.springboot.rabbitmq.config.RabbitMqConfig;
import com.springboot.rabbitmq.dto.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author: zenan
 * @date: 2021/5/18
 */
@Service
public class MessageListener {

    @RabbitListener(queues = RabbitMqConfig.TOPIC_QUEUE)
    public void receive(Message message) {
        System.out.println(message);
    }

}
