package com.springboot.validation.vo;

import lombok.Data;

/**
 * @author: zenan
 * @date: 2021/5/17
 */
@Data
public class ResultVO<T> {

    // 错误码
    private Integer code;
    // 提示信息
    private String message;
    // 具体内容
    private T data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultVO failed(Integer code, String message) {
        return new ResultVO(code, message, null);
    }
}
