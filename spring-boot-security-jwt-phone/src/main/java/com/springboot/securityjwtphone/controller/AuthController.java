package com.springboot.securityjwtphone.controller;

import com.springboot.securityjwtphone.dto.user.UserLoginForm;
import com.springboot.securityjwtphone.utils.CommonUtils;
import com.springboot.securityjwtphone.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: zenan
 * @date: 2021/4/22
 */
@Slf4j
@RequestMapping("/auth")
@RestController
public class AuthController {

    public static final ConcurrentHashMap<String, String> codeMap = new ConcurrentHashMap<>();

    @Value(value = "${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 获取验证码
     * @return CommonResult
     */
    @GetMapping("/verification")
    public String verify(@RequestParam(value = "mobile") String mobile) {
        String code = CommonUtils.createRandomVerificationCode();
        codeMap.put(mobile, code);
        log.info(code);
        return "success";
    }

    /**
     *
     * @param userLoginForm 登陆表单
     * @return CommonResult
     */
    @PostMapping("/login")
    public String login(@RequestBody UserLoginForm userLoginForm) {
        String mobile = userLoginForm.getMobile();
        String code = codeMap.get(mobile);
        if (!StringUtils.hasLength(code) || !code.equals(userLoginForm.getCode())) {
            return "error";
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(mobile);
        return tokenHead + jwtTokenUtil.generateToken(userDetails);
    }
}
