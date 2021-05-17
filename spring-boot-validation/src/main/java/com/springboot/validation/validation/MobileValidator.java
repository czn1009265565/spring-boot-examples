package com.springboot.validation.validation;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author: zenan
 * @date: 2021/5/17
 */
public class MobileValidator implements ConstraintValidator<IsMobile, String> {

    private boolean required = false;

    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required) {
            return value.matches("1[3456789]\\d{9}");
        }

        if (StringUtils.hasLength(value)){
            return value.matches("1[3456789]\\d{9}");
        }
        return true;
    }

}
