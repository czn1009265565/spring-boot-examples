package com.springboot.securityform.config;

import com.springboot.securityform.handler.AuthFailureHandler;
import com.springboot.securityform.handler.AuthSuccessHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author: zenan
 * @date: 2021/4/8
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

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
                // 自定义登录界面
                .loginPage("/auth/login")
                // 指定处理登录请求的路径
                .loginProcessingUrl("/auth/login")
                // 自定义登陆成功处理逻辑
                .successHandler(new AuthSuccessHandler())
                // 自定义失败处理逻辑
                .failureHandler(new AuthFailureHandler())
                .and()
                // 指定的登出路径
                .logout().logoutUrl("/auth/logout")
                .and()
                .httpBasic().disable()
                .csrf().disable()
                ;
    }
}
