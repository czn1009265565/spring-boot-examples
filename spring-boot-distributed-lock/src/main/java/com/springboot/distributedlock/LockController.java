package com.springboot.distributedlock;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zenan
 * @date: 2021/5/30
 */
@Slf4j
@RestController
public class LockController {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/lock")
    public void lock() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("解锁了");
    }

    @GetMapping("/distributedLock")
    public void distributedLock() {
        RLock rLock = redissonClient.getLock("lock");

        try {
            boolean b = rLock.tryLock();
            if (b) {
                log.info("开始下单");
                // 模拟业务处理
                Thread.sleep(3000);
                // 锁释放
                rLock.unlock();
            } else {
                log.info("很遗憾");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
