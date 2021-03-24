package com.springboot.shardingdbtable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.springboot.shardingdbtable.dao")
@SpringBootApplication
public class SpringBootShardingDbTableApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootShardingDbTableApplication.class, args);
    }

}
