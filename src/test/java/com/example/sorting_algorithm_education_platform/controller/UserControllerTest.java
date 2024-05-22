package com.example.sorting_algorithm_education_platform.controller;

import com.example.sorting_algorithm_education_platform.entity.User;
import com.example.sorting_algorithm_education_platform.service.Impl.UserServiceImpl;
import com.example.sorting_algorithm_education_platform.service.UserService;
import com.example.sorting_algorithm_education_platform.util.Res;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.geom.RectangularShape;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private User user;

    @MockBean
    private ResponseEntity responseEntity;

    @MockBean
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1);
        user.setEmail("test");
        user.setPassword("test");
    }

    @Test
    void login() throws Exception {
        String email = "test";
        String password = "test";
        Res<User> res = new Res<>();
        res.setCode(1);
        res.setData(user);
        res.setMsg("success");

        when(userService.login(email, password)).thenReturn(res);

        mockMvc.perform(post("/api/user/login")
                .param("email", email)
                .param("password", password))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andExpect(jsonPath("$.msg").value("success"))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.email").value("test"))
                .andExpect(jsonPath("$.data.password").value("test"));
    }

    @Test
    void register() throws Exception {
        String email = "test";
        String password = "test";
        Res<User> res = new Res<>();
        res.setCode(1);
        res.setData(user);
        res.setMsg("success");

        when(userService.register(email, password)).thenReturn(res);

        mockMvc.perform(post("/api/user/register")
                .param("email", email)
                .param("password", password))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andExpect(jsonPath("$.msg").value("success"))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.email").value("test"))
                .andExpect(jsonPath("$.data.password").value("test"));
    }
}
