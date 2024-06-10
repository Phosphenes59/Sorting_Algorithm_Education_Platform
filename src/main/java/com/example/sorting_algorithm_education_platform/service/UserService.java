package com.example.sorting_algorithm_education_platform.service;

import com.example.sorting_algorithm_education_platform.entity.User;
import com.example.sorting_algorithm_education_platform.mapper.UserMapper;
import com.example.sorting_algorithm_education_platform.util.Res;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {
    boolean userIdExists(int userId);
    Res<User> login(String email, String password);
    Res<User> register(String email,String password,String phone);
}
