package com.example.sorting_algorithm_education_platform.service.Impl;

import com.example.sorting_algorithm_education_platform.entity.User;
import com.example.sorting_algorithm_education_platform.mapper.UserMapper;
import com.example.sorting_algorithm_education_platform.service.UserService;
import com.example.sorting_algorithm_education_platform.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean userIdExists(int userId) {
        User user = userMapper.findUserById(userId);
        return user != null;
    }

    @Override
    public Res<User> login(String email, String password) {
        User user=userMapper.findUserByEmail(email);
        if (user==null){
            return new Res<>(0,"用户未注册",null);
        }
        user=userMapper.findUserByEmailAndPassword(email,password);
        if (user==null){
            return new Res<>(0,"密码错误！",null);
        }
        else {
            return new Res<>(1,"success",user);
        }
    }

    @Override
    public Res<User> register(String email, String password, String userName, String phone) {
        User user=new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUserName(userName);
        user.setPhone(phone);
        user.setIsAdmin(0);
        if (userMapper.findUserByEmail(email)!=null){
            return new Res<>(0,"用户已经存在",null);
        }
        else {
            userMapper.insertUser(user);
            return new Res<>(1,"success",user);
        }
    }

    @Override
    public Res<User> modify(Integer id, String email,String password, String userName, String phone){
        User user = userMapper.findUserById(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setUserName(userName);
        user.setPhone(phone);
        userMapper.updateById(user);
        return new Res<>(1,"success",user);
    }
}
