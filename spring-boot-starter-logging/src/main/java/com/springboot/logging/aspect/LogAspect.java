package com.springboot.logging.aspect;

import com.springboot.logging.utils.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统日志: 切面处理类
 * @author: zenan
 * @date: 2021/3/30
 */
@Slf4j
@Aspect
@Component
public class LogAspect {
    @Pointcut("@within(com.springboot.logging.annotation.SysLog)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        HttpServletRequest request = LogUtils.obtainServlet();
        String uri = request.getRequestURI();
        String ip = LogUtils.obtainIp(request);
        String params = LogUtils.obtainRequestParam(joinPoint);
        log.info("Url:{} IP:{} args:{}", uri, ip, params);
    }
}
