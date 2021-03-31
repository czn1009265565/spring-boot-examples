package com.springboot.logging.enums;

import lombok.Getter;

/**
 * @author: zenan
 * @date: 2021/3/30
 */
@Getter
public enum LogTypeEnum {
    INFO("INFO"),
    ERROR("ERROR");

    private String desc;

    LogTypeEnum(String desc) {
        this.desc = desc;
    }

    public static boolean contains(String value) {
        return INFO.getDesc().equals(value) || ERROR.getDesc().equals(value);
    }
}
