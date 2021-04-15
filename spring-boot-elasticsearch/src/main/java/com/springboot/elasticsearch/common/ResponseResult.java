package com.springboot.elasticsearch.common;

import lombok.Data;

/**
 * @author: zenan
 * @date: 2021/4/15
 */
@Data
public class ResponseResult<T> {
    private Integer code;

    private String message;

    private T data;

    public ResponseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static <T> ResponseResult<T> failed(T data) {
        return new ResponseResult<T>(ResultEnum.FAILED.getCode(), ResultEnum.FAILED.getMessage(), data);
    }
}
