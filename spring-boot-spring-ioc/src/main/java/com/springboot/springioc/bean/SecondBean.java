package com.springboot.springioc.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: zenan
 * @date: 2021/6/11
 */
public class SecondBean implements BeanNameAware {

    private String name;

    @Autowired
    private FirstBean firstBean;


    public SecondBean() {
        System.out.println("SecondBean 实例化");
    }

    @PostConstruct
    public void init() {
        System.out.println("SecondBean init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("SecondBean destroy");
    }

    @Override
    public void setBeanName(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }
}
