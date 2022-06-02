package com.example.demot.service.impl;

import com.example.demot.bean.LoginUser;
import com.example.demot.bean.User;
import com.example.demot.config.ResponseResult;
import com.example.demot.service.LoginService;
import com.example.demot.util.JwtUtil;
import com.example.demot.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    RedisCache redisCache;

    @Override
    public ResponseResult login( User user) {
        UsernamePasswordAuthenticationToken userToken =
                new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(userToken);
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        LoginUser loginUser =  (LoginUser)authenticate.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userid);
        Map map =new  HashMap<String,String>();
        map.put("token",jwt);
        redisCache.setCacheObject("login:"+userid,loginUser);
        return new ResponseResult(200,"成功",map);
    }
}
