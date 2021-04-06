package com.springboot.logging.aspect;

import com.springboot.logging.service.OperationService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 操作记录: 切面处理类
 * @author: zenan
 * @date: 2021/3/30
 */
@Slf4j
@Aspect
public class OperationAspect {

    @Autowired
    private OperationService operationService;

    @Pointcut("@annotation(com.springboot.logging.annotation.SysLog)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object operationAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        operationService.create(joinPoint);
        return result;
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "e")
    public void operationThrowing(JoinPoint joinPoint, Throwable e){
        operationService.create((ProceedingJoinPoint) joinPoint, e);
    }
}
