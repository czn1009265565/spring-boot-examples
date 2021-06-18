package com.springboot.springbootaop.jdk动态代理;

import com.springboot.springbootaop.jdk动态代理.PersonService;

/**
 * @author: zenan
 * @date: 2021/6/18
 */
public class PersonServiceImpl implements PersonService {
    @Override
    public void talk() {
        System.out.println("talk");
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }
}
