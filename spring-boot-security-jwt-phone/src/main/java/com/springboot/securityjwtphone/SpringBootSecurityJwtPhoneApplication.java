package com.springboot.securityjwtphone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.springboot.securityjwtphone.dao")
@SpringBootApplication
public class SpringBootSecurityJwtPhoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityJwtPhoneApplication.class, args);
    }

}
