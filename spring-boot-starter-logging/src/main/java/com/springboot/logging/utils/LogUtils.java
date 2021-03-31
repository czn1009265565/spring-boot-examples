package com.springboot.logging.utils;

import com.springboot.logging.annotation.SysLog;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 日志工具类
 * @author: zenan
 * @date: 2021/3/30
 */
public class LogUtils {
    /**
     * 获取用户名
     * @return 用户名
     */
    public static String obtainUsername(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userDetails.getUsername();
        }
        return "";
    }

    /**
     * 获取日志描述
     * @param joinPoint 切点
     * @return 日志描述
     */
    public static String obtainDescription(ProceedingJoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog operation = method.getAnnotation(SysLog.class);
        return operation.value();
    }

    /**
     * 获取方法名
     * @param joinPoint 切点
     * @return 方法名
     */
    public static String obtainMethodName(ProceedingJoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return joinPoint.getTarget().getClass().getName() + "." + signature.getName() + "()";
    }

    /**
     * 获取servlet
     * @return HttpServletRequest
     */
    public static HttpServletRequest obtainServlet(){
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    /**
     * 获取浏览器
     * @param request HttpServletRequest
     * @return 浏览器
     */
    public static String obtainBrowser(HttpServletRequest request){
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        Browser browser = userAgent.getBrowser();
        return browser.getName();
    }

    /**
     * 获取真实IP地址
     * @param request HttpServletRequest
     * @return IP地址
     */
    public static String obtainIp(HttpServletRequest request){
        String addr = request.getRemoteAddr();
        // 获取经过Nginx代理后的真实用户ip
        String forwarded = request.getHeader("X-Forwarded-For");
        String real = request.getHeader("X-Real-IP");
        if (StringUtils.hasLength(forwarded) && !"unknown".equals(forwarded)) return forwarded;
        if (StringUtils.hasLength(real) && !"unknown".equals(real)) return real;
        return addr;
    }

    /**
     * 获取请求参数
     * @param joinPoint 切点
     * @return 请求参数
     */
    public static String obtainRequestParam(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String[] paramNames = u.getParameterNames(method);

        StringBuilder params = new StringBuilder();
        if (args != null && paramNames != null) {
            for (int i = 0; i < args.length; i++) {
                params.append("  ").append(paramNames[i]).append(": ").append(args[i]);
            }
        }
        return params.toString();
    }
}
