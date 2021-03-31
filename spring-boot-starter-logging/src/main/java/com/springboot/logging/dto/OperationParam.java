package com.springboot.logging.dto;

import lombok.Data;

/**
 * 用户操作记录查询对象
 */
@Data
public class OperationParam extends PageParam{

    private String username;

    private String description;

    private String requestIp;
}
