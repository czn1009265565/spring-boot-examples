package com.springboot.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String DIRECT_QUEUE = "direct.queue";

    public static final String TOPIC_QUEUE = "topic.queue";
    public static final String TOPIC_EXCHANGE = "topicExchange";

    public static final String FANOUT_QUEUE = "fanout.queue";
    public static final String FANOUT_EXCHANGE = "fanoutxchage";

    /**
     * MessageConverter用于将Java对象转换为RabbitMQ的消息。默认情况下，
     * Spring Boot使用SimpleMessageConverter，只能发送String和byte[]类型的消息，不太方便。
     * 使用Jackson2JsonMessageConverter，我们就可以发送JavaBean对象，由Spring Boot自动序列化为JSON并以文本消息传递。
     */
    @Bean
    public MessageConverter createMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Direct 模式
     * @return Queue
     */
    @Bean
    public Queue queue() {
        return new Queue(DIRECT_QUEUE, true);
    }


    /**
     * Topic 模式
     * @return Queue
     */
    @Bean
    public Queue topicQueue() {
        return new Queue(TOPIC_QUEUE, true);
    }

    @Bean
    public TopicExchange topicExchage(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding topicBinding() {
        return BindingBuilder.bind(topicQueue()).to(topicExchage()).with("topic.#");
    }

    /**
     * Fanout 模式
     * @return Queue
     */
    @Bean
    public Queue fanoutQueue() {
        return new Queue(FANOUT_QUEUE, true);
    }

    @Bean
    public FanoutExchange fanoutExchage(){
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding FanoutBinding1() {
        return BindingBuilder.bind(fanoutQueue()).to(fanoutExchage());
    }
}
