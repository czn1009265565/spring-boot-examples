package com.springboot.shardingtable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.springboot.shardingtable.dao"})
@SpringBootApplication
public class SpringBootShardingTableApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootShardingTableApplication.class, args);
    }

}
