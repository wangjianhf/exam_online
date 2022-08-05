package com.exam.online.service;

import com.exam.online.bean.*;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    User login(User user);
}
