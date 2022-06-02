package com.example.demot.filter;

import com.example.demot.bean.LoginUser;
import com.example.demot.util.JwtUtil;
import com.example.demot.util.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/*
* 继承OncePerRequestFilter而不是Filter 为了兼容不同的servlet 版本
* */
@Component
public class SecurityTokenFilter extends OncePerRequestFilter{
    @Autowired
    RedisCache redisCache;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader("token");
        if(!StringUtils.hasText(token)) {
            //放行
             filterChain.doFilter(httpServletRequest,httpServletResponse);
             return;
        }
        Claims claims;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            throw new RuntimeException("token解析失败");
        }
        String userid = claims.getSubject();
        LoginUser loginUser = redisCache.getCacheObject("login:" +userid);
        if (Objects.isNull(loginUser)) {
            throw  new RuntimeException("用户未登录");
        }
        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(loginUser,null,null));
        //放行
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
