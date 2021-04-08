package com.springboot.securityuserauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.springboot.securityuserauth.dao")
@SpringBootApplication
public class SpringBootSecurityUserAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityUserAuthApplication.class, args);
    }

}
