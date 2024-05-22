package com.example.sorting_algorithm_education_platform.service;

import com.example.sorting_algorithm_education_platform.entity.User;
import com.example.sorting_algorithm_education_platform.mapper.UserMapper;
import com.example.sorting_algorithm_education_platform.service.Impl.UserServiceImpl;
import com.example.sorting_algorithm_education_platform.util.Res;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    //未注册用户登录
    void login() {
        String email = "test";
        String password = "test";
        Res<User> res = new Res<>();

        when(userMapper.findUserByEmail(email)).thenReturn(null);

        res = userService.login(email, password);
        assertEquals(0, res.getCode());
        assertEquals("用户未注册", res.getMsg());
        assertNull(res.getData());
    }

    @Test
    //密码错误
    void login2() {
        String email = "test";
        String password = "wrong";
        Res<User> res = new Res<>();
        User user = new User();
        user.setEmail(email);
        user.setPassword("wrong");

        when(userMapper.findUserByEmail(email)).thenReturn(user);
        when(userMapper.findUserByEmailAndPassword(email,password)).thenReturn(null);

        res = userService.login(email, password);

        assertEquals(0, res.getCode());
        assertEquals("密码错误！", res.getMsg());
        assertNull(res.getData());
    }

    @Test
    //登录成功
    void login3() {
        String email = "test";
        String password = "test";
        Res<User> res = new Res<>();
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        when(userMapper.findUserByEmail(email)).thenReturn(user);
        when(userMapper.findUserByEmailAndPassword(email,password)).thenReturn(user);

        res = userService.login(email, password);

        assertEquals(1, res.getCode());
        assertEquals("success", res.getMsg());
        assertEquals(user, res.getData());
    }

    @Test
    //用户已存在
    void register() {
        String email = "test";
        String password = "test";
        Res<User> res = new Res<>();
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        when(userMapper.findUserByEmail(email)).thenReturn(user);

        res = userService.register(email, password);

        assertEquals(0, res.getCode());
        assertEquals("用户已经存在", res.getMsg());
        assertNull(res.getData());
    }

    @Test
    //注册成功
    void register2() {
        String email = "test";
        String password = "test";
        Res<User> res = new Res<>();
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        when(userMapper.findUserByEmail(email)).thenReturn(null);

        res = userService.register(email, password);

        assertEquals(1, res.getCode());
        assertEquals("success", res.getMsg());
        assertEquals(user, res.getData());
    }

}
