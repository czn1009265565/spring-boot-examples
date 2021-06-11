package com.springboot.springioc.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author: zenan
 * @date: 2021/6/9
 */
public class FirstBean implements InitializingBean, DisposableBean {

    @Autowired
    private SecondBean secondBean;

    public FirstBean() {
        System.out.println("FirstBean 实例化");
    }

    @Override
    public void destroy() {
        System.out.println("FirstBean destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("FirstBean init");
    }
}
