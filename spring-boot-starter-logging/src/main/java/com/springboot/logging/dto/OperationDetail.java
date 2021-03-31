package com.springboot.logging.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户操作记录详情
 */
@Data
public class OperationDetail {
    private Long id;

    private String username;

    private String description;

    private String method;

    private String params;

    private String logType;

    private String requestIp;

    private String address;

    private String browser;

    private String exception;

    private LocalDateTime createTime;
}
