package com.example.sorting_algorithm_education_platform.service;

import com.example.sorting_algorithm_education_platform.entity.User;
import com.example.sorting_algorithm_education_platform.util.Res;

public interface UserService {
    Res<User> login(String email, String password);
    Res<User> register(String email,String password);
}
