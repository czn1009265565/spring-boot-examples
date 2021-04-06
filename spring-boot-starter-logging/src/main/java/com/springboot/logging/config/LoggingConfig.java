package com.springboot.logging.config;

import com.springboot.logging.aspect.LogAspect;
import com.springboot.logging.aspect.OperationAspect;
import com.springboot.logging.controller.OperationController;
import com.springboot.logging.service.OperationService;
import com.springboot.logging.service.OperationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zenan
 * @date: 2021/4/6
 */
@Configuration
public class LoggingConfig {

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }

    @Bean
    public OperationAspect operationAspect() {
        return new OperationAspect();
    }

    @Bean
    public OperationController operationController() {
        return new OperationController();
    }

    @Bean
    public OperationService operationService() {
        return new OperationServiceImpl();
    }
}
