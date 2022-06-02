package com.example.demot.service.impl;

import com.example.demot.bean.LoginUser;
import com.example.demot.bean.User;
import com.example.demot.dao.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    SysUserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.findByUserName(s);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户不存在");
        }
        return new LoginUser(user);
    }
}
