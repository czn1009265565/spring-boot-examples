package com.springboot.smsaliyun.service;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.springboot.smsaliyun.config.SmsProperties;
import com.springboot.smsaliyun.dto.SmsMessage;
import com.springboot.smsaliyun.enums.SmsActionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zenan
 * @date: 2021/5/6
 */
@Service
public class SmsServiceImpl implements SmsService {
    public static final Logger log = LoggerFactory.getLogger(SmsServiceImpl.class);

    public static final MethodType SYS_METHOD = MethodType.POST;
    public static final String SYS_DOMAIN = "dysmsapi.aliyuncs.com";
    public static final String SYS_VERSION = "2017-05-25";

    @Autowired
    private SmsProperties smsProperties;

    @Autowired
    private IAcsClient iAcsClient;


    @Override
    public void send(SmsMessage smsMessage) {
        String receiver = smsMessage.getReceiver();
        String smsCode = smsMessage.getSmsCode();

        CommonRequest request = new CommonRequest();
        request.setSysMethod(SYS_METHOD);
        request.setSysDomain(SYS_DOMAIN);
        request.setSysVersion(SYS_VERSION);
        request.setSysAction(SmsActionEnum.SEND_SMS.getCode());
        request.putQueryParameter("RegionId", smsProperties.getRegionId());
        request.putQueryParameter("PhoneNumbers", receiver);
        request.putQueryParameter("SignName", smsProperties.getSignName());
        request.putQueryParameter("TemplateCode", smsProperties.getTemplateCode());

        request.putQueryParameter("TemplateParam", String.format("{\"code\":\"%s\"}", smsCode));

        try {
            CommonResponse response = iAcsClient.getCommonResponse(request);
            if (response.getData().contains("\"Message\":\"OK\"")) {
                log.info("sms发送成功 mobile:{} code:{}", receiver, smsCode);
            } else {
                log.info("sms发送失败 mobile:{} code:{} reason:{}", receiver, smsCode, response.getData());
            }
        } catch (ClientException e) {
            log.warn("sms发送失败 mobile:{} code:{}", receiver, smsCode, e);
        }

    }
}
