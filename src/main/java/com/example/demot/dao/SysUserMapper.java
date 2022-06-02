package com.example.demot.dao;


import com.example.demot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @author tjk
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2022-06-01 14:22:24
* @Entity generator.demot.SysUser
*/
@Component
@Mapper
public interface SysUserMapper {
   public List<User> findByName();
   public User findByUserName(String s);

}




