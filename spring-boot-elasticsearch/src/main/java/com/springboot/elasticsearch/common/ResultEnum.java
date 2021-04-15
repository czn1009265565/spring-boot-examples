package com.springboot.elasticsearch.common;

import lombok.Getter;

/**
 * @author: zenan
 * @date: 2021/4/15
 */
@Getter
public enum ResultEnum {
    SUCCESS(0, "操作成功"),
    FAILED(1, "操作失败")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
