package com.example.demot.Controller;

import com.example.demot.bean.User;
import com.example.demot.config.ResponseResult;
import com.example.demot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Login {
    @Autowired
    LoginService loginService;

   /* @Autowired
    RedisUtil redisUtil;
    @GetMapping("/login")
    public String login() {
        redisUtil.set("name","王五");
         return "login";
    }*/
    @PostMapping("/login")
    public ResponseResult redisTest(@RequestBody User user) {



       return loginService.login(user);
    }

    @PostMapping("/hello")
    public ResponseResult Sayhello(@RequestBody User user) {



        return new ResponseResult(200,"hello",null);
    }

}
