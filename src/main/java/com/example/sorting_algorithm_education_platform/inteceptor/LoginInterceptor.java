package com.example.sorting_algorithm_education_platform.inteceptor;

import com.example.sorting_algorithm_education_platform.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Claims claims= JwtUtil.parse(request.getHeader("Authorization"));
        return claims!=null && claims.get("id")!=null;
    }
}