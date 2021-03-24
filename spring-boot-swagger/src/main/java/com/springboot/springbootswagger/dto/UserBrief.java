package com.springboot.springbootswagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: zenan
 * @date: 2021/3/24
 */
@Data
@ApiModel(value = "用户简介")
public class UserBrief {
    @ApiModelProperty(value = "用户Id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;
}
