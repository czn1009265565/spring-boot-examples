package com.springboot.seatabusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringBootSeataBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSeataBusinessApplication.class, args);
    }

}
