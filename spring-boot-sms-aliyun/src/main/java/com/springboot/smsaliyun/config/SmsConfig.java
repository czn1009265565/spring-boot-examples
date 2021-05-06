package com.springboot.smsaliyun.config;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zenan
 * @date: 2021/5/6
 */
@Configuration
public class SmsConfig {

    @Autowired
    private SmsProperties smsProperties;

    @Bean
    public IAcsClient iAcsClient() {
        DefaultProfile profile = DefaultProfile.getProfile(
                smsProperties.getRegionId(),
                smsProperties.getAccessKeyId(),
                smsProperties.getSecret());
        return new DefaultAcsClient(profile);
    }
}
