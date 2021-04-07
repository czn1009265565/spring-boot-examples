package com.springboot.mail.config;

import com.springboot.mail.service.MailService;
import com.springboot.mail.service.MailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConfigure {

    @Bean
    public MailService mailService() {
        return new MailServiceImpl();
    }
}
