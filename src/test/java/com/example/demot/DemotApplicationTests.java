package com.example.demot;

import com.example.demot.bean.User;
import com.example.demot.dao.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;
import java.util.List;

@SpringBootTest
class DemotApplicationTests {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    SysUserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    void contextLoads() {
    }
    @Test
    void Test1() {
        System.out.println(passwordEncoder.encode("123"));
    }

}
