package com.springboot.validation.dto;

import com.springboot.validation.validation.IsMobile;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author: zenan
 * @date: 2021/5/17
 */
@Data
public class Form {
    @IsMobile
    private String mobile;

    @NotBlank
    @Email
    private String email;
}
