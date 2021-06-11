package com.springboot.springioc.config;

import com.springboot.springioc.bean.FirstBean;
import com.springboot.springioc.bean.SecondBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这里存在循环依赖问题(B注入半成品A)
 * 结合Bean的生命周期
 * 1. 实例化
 * 2. 属性赋值(递归调用)
 * 3. setBeanName
 * 4. setBeanFactory
 * 5. setApplicationContext
 * 6. BeforeInit
 * 7. init初始化
 * 8. AfterInit
 * 9. destroy
 */
@Configuration
public class WebConfig {

    @Bean
    public FirstBean firstBean() {
        return new FirstBean();
    }

    @Bean
    public SecondBean secondBean() {
        return new SecondBean();
    }
}
