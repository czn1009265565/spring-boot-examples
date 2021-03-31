package com.springboot.logging.dto;

import lombok.Data;

/**
 * @author: zenan
 * @date: 2021/3/30
 */
@Data
public class PageParam {
    public static final int PAGE_NUM = 1;
    public static final int PAGE_SIZE = 20;

    private Integer pageNum;

    private Integer pageSize;


    public Integer getPageNum() {
        if (pageNum != null) {
            return pageNum;
        }
        return PAGE_NUM;
    }

    public Integer getPageSize() {
        if (pageSize != null) {
            return pageSize;
        }
        return PAGE_SIZE;
    }
}
