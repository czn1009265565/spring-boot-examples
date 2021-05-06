package com.springboot.smsaliyun.enums;

/**
 * @author: zenan
 * @date: 2021/5/6
 */
public enum SmsActionEnum {
    SEND_SMS("SendSms", "发送短信")
    ;


    private String code;
    private String message;

    SmsActionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
