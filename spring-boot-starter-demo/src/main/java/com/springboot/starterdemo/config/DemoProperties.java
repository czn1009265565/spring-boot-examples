package com.springboot.starterdemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: zenan
 * @date: 2021/4/6
 */
@Data
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {

    private String host = "127.0.0.1";

    private String port = "8080";
}
