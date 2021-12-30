package com.single.blog.base.config;

import com.alibaba.fastjson.JSON;
import com.single.blog.base.exception.BusinessRuntimeException;
import com.single.blog.base.bean.result.ResultDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Value("${blog.expireTime}")
    private Long expireTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String accountName = null;
        String token = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("accountName".equals(cookie.getName())) {
                    accountName = cookie.getValue();
                }
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                }
            }
            if (accountName == null || "".equals(accountName)) {
                this.setFailureResponse(response);
                return false;
            }
            if (token == null || "".equals(token)) {
                this.setFailureResponse(response);
                return false;
            }
            String redisToken = stringRedisTemplate.opsForValue().get(accountName);
            if (redisToken != null && redisToken.equals(token)) {
                Long expire = stringRedisTemplate.getExpire(accountName, TimeUnit.MINUTES);
                if (expire != null && expire < 5L) {
                    stringRedisTemplate.opsForValue().set(accountName, redisToken, expireTime, TimeUnit.MINUTES);
                }
                return true;
            }
        }
        this.setFailureResponse(response);
        return false;
    }

    private void setFailureResponse(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(JSON.toJSONString(ResultDTO.unauthorized("未授权，请登录！")));
            writer.flush();
        } catch (Exception e) {
            throw new BusinessRuntimeException(e.getMessage());
        }
    }
}
