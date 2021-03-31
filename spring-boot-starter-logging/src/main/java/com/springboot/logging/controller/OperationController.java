package com.springboot.logging.controller;

import com.springboot.logging.annotation.SysLog;
import com.springboot.logging.convert.OperationConvert;
import com.springboot.logging.dto.OperationDetail;
import com.springboot.logging.dto.OperationParam;
import com.springboot.logging.entity.Operation;
import com.springboot.logging.service.OperationService;
import com.springboot.logging.vo.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zenan
 * @date: 2021/3/30
 */
@Slf4j
@SysLog
@RestController
@RequestMapping(value = "/api/operation")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping
    public PageResult<OperationDetail> list(OperationParam operationParam) {
        List<Operation> operationList = operationService.list(operationParam);
        List<OperationDetail> operationDetailList = OperationConvert.INSTANCE.entityToDetail(operationList);
        PageResult pageResult = PageResult.page(operationList);
        pageResult.setData(operationDetailList);
        return pageResult;
    }
}
