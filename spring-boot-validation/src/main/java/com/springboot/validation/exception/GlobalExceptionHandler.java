package com.springboot.validation.exception;

import com.springboot.validation.vo.ResultEnum;
import com.springboot.validation.vo.ResultVO;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * @author: zenan
 * @date: 2021/5/17
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // 通用@valid表单参数异常处理
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultVO notValidExceptionHandle(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        Objects.requireNonNull(bindingResult.getFieldError()); // 空指针

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.PARAM_ERROR.getCode());
        resultVO.setMessage(bindingResult.getFieldError().getField() + " " + bindingResult.getFieldError().getDefaultMessage());

        return resultVO;
    }

    // Spring Boot 2.3
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultVO notValidExceptionHandle(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        Objects.requireNonNull(bindingResult.getFieldError()); // 空指针

        Integer code = ResultEnum.PARAM_ERROR.getCode();
        String message = bindingResult.getFieldError().getField() + " " + bindingResult.getFieldError().getDefaultMessage();
        return ResultVO.failed(code, message);
    }
}
