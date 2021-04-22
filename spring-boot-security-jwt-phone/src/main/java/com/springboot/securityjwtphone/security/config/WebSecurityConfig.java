package com.springboot.securityjwtphone.security.config;

import com.springboot.securityjwtphone.security.filter.JwtAuthenticationTokenFilter;
import com.springboot.securityjwtphone.security.handler.RestAuthenticationEntryPoint;
import com.springboot.securityjwtphone.security.handler.RestfulAccessDeniedHandler;
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
 * @date: 2021/4/22
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;


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
                .antMatchers("/auth/login", "/auth/verification").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
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
