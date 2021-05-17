package com.springboot.validation.vo;

import lombok.Getter;

/**
 * @author: zenan
 * @date: 2021/5/17
 */
@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),
    PARAM_ERROR(1, "参数不正确"),
    NOT_FOUND(2, "该数据不存在"),
    TIME_OUT(3, "已超时"),
    ;
    private final Integer code;
    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
