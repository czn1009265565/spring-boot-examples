package com.springboot.nettysimple;

import com.springboot.nettysimple.netty.WSServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: zenan
 * @date: 2021/4/23
 */
@Slf4j
@Order(1)
@Component
public class WSServerBootStrap implements ApplicationRunner {

    @Autowired
    private WSServer wsServer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            wsServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
