package com.example.sorting_algorithm_education_platform.controller;

import com.example.sorting_algorithm_education_platform.entity.User;
import com.example.sorting_algorithm_education_platform.service.UserService;
import com.example.sorting_algorithm_education_platform.util.JwtUtil;
import com.example.sorting_algorithm_education_platform.util.Res;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private int getIdFromToken(HttpServletRequest request){
        Claims claims= JwtUtil.parse(request.getHeader("Authorization"));
        if (claims==null) return -1;
        return (int) claims.get("id");
    }

    @PostMapping("/login")
    public ResponseEntity<Res<User>> login(@RequestParam(value = "email") String email,
                                           @RequestParam(value = "password") String password,
                                           HttpServletResponse response){
        Res<User> result=userService.login(email, password);
        if (result.getCode()==1){
            String accessToken = JwtUtil.createJWT(result.getData().getId());
            response.setHeader("Authorization",accessToken);
        }
        return ResponseEntity.ok(result);
    }
    @PostMapping("/register")
    public ResponseEntity<Res<User>> register(@RequestParam(value = "email") String email,
                                              @RequestParam(value = "password") String password,
                                              @RequestParam(value = "phone")String phone){
        return ResponseEntity.ok(userService.register(email, password,phone));
    }
}
