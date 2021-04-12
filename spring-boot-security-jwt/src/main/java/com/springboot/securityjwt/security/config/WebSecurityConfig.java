package com.springboot.securityjwt.security.config;

import com.springboot.securityjwt.security.filter.JwtAuthenticationTokenFilter;
import com.springboot.securityjwt.security.handler.AuthFailureHandler;
import com.springboot.securityjwt.security.handler.AuthSuccessHandler;
import com.springboot.securityjwt.security.handler.RestAuthenticationEntryPoint;
import com.springboot.securityjwt.security.handler.RestfulAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author: zenan
 * @date: 2021/4/12
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    @Autowired
    private AuthFailureHandler authFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * Security 提供了很多配置相关，对应命名空间配置中的子标签
     * authorizeRequests() <intercept-url></intercept-url>
     * formLogin() <form-login></form-login>
     * httpBasic() <http-basic></http-basic>
     * csrf() <csrf></csrf>
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/auth/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // 指定处理登录请求的路径
                .loginProcessingUrl("/auth/login")
                // 自定义登陆成功处理逻辑
                .successHandler(authSuccessHandler)
                // 自定义失败处理逻辑
                .failureHandler(authFailureHandler)
                .and()
                // 关闭 Http 基础认证
                .httpBasic().disable()
                // 关闭 csrf 校验
                .csrf().disable()
                // 关闭session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 新增 未登录和未授权处理
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .accessDeniedHandler(restfulAccessDeniedHandler)
        ;
        // 禁用缓存
        http.headers().cacheControl();
        // 添加 JWT Filter
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}

