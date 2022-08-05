package com.exam.online.service.Impl;


import com.exam.online.bean.User;
import com.exam.online.mapper.UserMapper;
import com.exam.online.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.queryUser(user);
    }
}
