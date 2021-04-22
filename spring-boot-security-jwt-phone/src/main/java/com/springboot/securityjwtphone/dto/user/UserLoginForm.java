package com.springboot.securityjwtphone.dto.user;

import lombok.Data;

/**
 * @author: zenan
 * @date: 2021/4/22
 */
@Data
public class UserLoginForm {
    /**
     * 手机号
     */
    private String mobile;

    /**
     * 短信验证码
     */
    private String code;
}
