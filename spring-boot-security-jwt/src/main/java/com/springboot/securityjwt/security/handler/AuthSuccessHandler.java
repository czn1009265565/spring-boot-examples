package com.springboot.securityjwt.security.handler;

import com.google.gson.Gson;
import com.springboot.securityjwt.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录成功处理类
 * @author: zenan
 * @date: 2021/4/12
 */
@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    @Value(value = "${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private Gson gson;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        httpServletResponse.setContentType("application/json;charset=utf-8");

        Map<String, String> result = new HashMap<>();
        result.put("token", jwtTokenUtil.generateToken(userDetails));
        result.put("tokenHead", tokenHead);
        httpServletResponse.getWriter().write(gson.toJson(result));
    }
}