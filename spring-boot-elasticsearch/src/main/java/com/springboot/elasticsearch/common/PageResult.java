package com.springboot.elasticsearch.common;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author: zenan
 * @date: 2021/4/15
 */
@Data
public class PageResult<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    public static <T> PageResult<T> restPage(Page<T> page) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageNum(page.getNumber());
        pageResult.setPageSize(page.getSize());
        pageResult.setTotalPage(page.getTotalPages());
        pageResult.setTotal(page.getTotalElements());
        pageResult.setList(page.getContent());
        return pageResult;
    }
}
