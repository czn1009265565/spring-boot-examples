package com.springboot.smsaliyun.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: zenan
 * @date: 2021/5/6
 */
@Component
@ConfigurationProperties(prefix = "aliyun.sms")
public class SmsProperties {

    private String accessKeyId;

    private String secret;

    /**
     * 短信签名名称
     */
    private String signName;

    /**
     * 短信模板Id
     */
    private String templateCode;

    private String regionId;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }
}
