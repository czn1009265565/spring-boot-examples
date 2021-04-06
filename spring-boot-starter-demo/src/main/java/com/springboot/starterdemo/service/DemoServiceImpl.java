package com.springboot.starterdemo.service;

import com.springboot.starterdemo.config.DemoProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: zenan
 * @date: 2021/4/6
 */
public class DemoServiceImpl implements DemoService{
    @Autowired
    private DemoProperties demoProperties;

    @Override
    public void test() {
        System.out.println(demoProperties.getHost() + ":" + demoProperties.getPort());
    }
}
