package com.example.demot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
@SpringBootApplication
@MapperScan("com.example.demot.dao")
public class DemotApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemotApplication.class, args);
    }

}
