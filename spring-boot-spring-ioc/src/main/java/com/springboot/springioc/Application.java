package com.springboot.springioc;

import com.springboot.springioc.bean.SecondBean;
import com.springboot.springioc.config.WebConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: zenan
 * @date: 2021/6/11
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(WebConfig.class);
        String[] beanNames = applicationContext.getBeanDefinitionNames();

        for (String beanName: beanNames) {
            System.out.println(beanName);
        }
        // 测试BeanNameAware的作用,获取beanName
        SecondBean secondBean = (SecondBean) applicationContext.getBean("secondBean");
        System.out.println("BeanNameAware 获取BeanName:" + secondBean.getName());
    }

}
