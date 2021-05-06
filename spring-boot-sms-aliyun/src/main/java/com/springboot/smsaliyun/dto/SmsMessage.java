package com.springboot.smsaliyun.dto;

/**
 * @author: zenan
 * @date: 2021/5/6
 */
public class SmsMessage {

    /**
     * 收件人
     */
    private String receiver;

    /**
     * 短信验证码
     */
    private String smsCode;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
