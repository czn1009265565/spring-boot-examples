package com.springboot.logging.service;

import com.springboot.logging.dto.OperationParam;
import com.springboot.logging.entity.Operation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zenan
 * @date: 2021/3/30
 */
@Service
public interface OperationService {
    int create(ProceedingJoinPoint joinPoint);

    int create(ProceedingJoinPoint joinPoint, Throwable e);

    List<Operation> list(OperationParam operationParam);
}
