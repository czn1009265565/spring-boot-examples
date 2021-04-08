package com.springboot.securityuserauth.security.config;

import com.springboot.securityuserauth.security.handler.AuthFailureHandler;
import com.springboot.securityuserauth.security.handler.AuthSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: zenan
 * @date: 2021/4/8
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

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
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER")
                .antMatchers("/app/**").permitAll()
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
