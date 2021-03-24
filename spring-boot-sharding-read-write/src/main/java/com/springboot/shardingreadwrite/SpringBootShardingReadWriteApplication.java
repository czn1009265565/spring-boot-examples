package com.springboot.shardingreadwrite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.springboot.shardingreadwrite.dao")
@SpringBootApplication
public class SpringBootShardingReadWriteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootShardingReadWriteApplication.class, args);
    }

}
