package com.springboot.springbootswagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: zenan
 * @date: 2021/3/24
 */
@Data
@ApiModel(value = "用户新增对象")
public class UserForm {
    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty("邮箱")
    private String email;

}
