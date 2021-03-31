package com.springboot.logging.vo;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * 分页对象
 */
@Data
public class PageResult<T> {
    private Integer pageNum;

    private Integer pageSize;

    private Integer pageTotal;

    private Integer total;

    private List<T> data;

    public static <T> PageResult<T> page(List<T> list) {
        PageResult<T> pageResult = new PageResult<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setPageTotal(pageInfo.getPages());
        pageResult.setTotal((int) pageInfo.getTotal());
        pageResult.setData(pageInfo.getList());
        return pageResult;
    }

    public static <T> PageResult<T> page(PageInfo<T> pageInfo) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setPageTotal(pageInfo.getPages());
        pageResult.setTotal((int) pageInfo.getTotal());
        pageResult.setData(pageInfo.getList());
        return pageResult;
    }
}
