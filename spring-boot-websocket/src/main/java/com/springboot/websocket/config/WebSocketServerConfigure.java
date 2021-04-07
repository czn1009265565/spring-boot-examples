package com.springboot.websocket.config;

import com.springboot.websocket.handler.StringWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author: zenan
 * @date: 2021/4/7
 */
@Configuration
@EnableWebSocket // 开启WebSocket相关功能
public class WebSocketServerConfigure implements WebSocketConfigurer {
    @Autowired
    private StringWebSocketHandler stringWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(stringWebSocketHandler, "/connect").withSockJS();
    }
}
