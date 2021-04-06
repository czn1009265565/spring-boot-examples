package com.springboot.starterdemo.config;

import com.springboot.starterdemo.service.DemoService;
import com.springboot.starterdemo.service.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zenan
 * @date: 2021/4/6
 */
@Configuration
@EnableConfigurationProperties({DemoProperties.class})
public class DemoConfig {

    @Bean
    public DemoService demoService() {
        return new DemoServiceImpl();
    }

}
