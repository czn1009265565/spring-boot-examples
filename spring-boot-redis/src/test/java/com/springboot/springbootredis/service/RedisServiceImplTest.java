package com.springboot.springbootredis.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: zenan
 * @date: 2021/4/30
 */
@SpringBootTest
class RedisServiceImplTest {
    @Autowired
    private RedisService redisService;

    @Test
    void set() {
        // test string
//        redisService.set("jwtToken", "1", 3600);
        redisService.set("key", new UserEntity("泽南", 20, true));
    }
}


class UserEntity {
    private String username;

    private Integer age;

    private boolean sex;

    public UserEntity(String username, Integer age, boolean sex) {
        this.username = username;
        this.age = age;
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}

