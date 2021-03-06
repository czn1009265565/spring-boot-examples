package com.springboot.validation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author: zenan
 * @date: 2021/5/17
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {MobileValidator.class })
public @interface  IsMobile {

    boolean required() default true;

    String message() default "手机号码格式错误";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
