package com.springboot.springbootaop.jdk动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: zenan
 * @date: 2021/6/18
 */
public class Application {
    public static void main(String[] args) {

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // @Around
                System.out.println("before");

                // 从Ioc容器中获取实例对象
                PersonServiceImpl personServiceImpl = new PersonServiceImpl();
                Object object = method.invoke(personServiceImpl, args);

                System.out.println("after");
                return object;
            }
        };


        PersonService personService = (PersonService) Proxy.newProxyInstance(
                PersonService.class.getClassLoader(),
                new Class[] {PersonService.class},
                invocationHandler
        );
        personService.eat();
        personService.talk();
    }
}
