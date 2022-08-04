package com.exam.online.service;

import com.exam.online.bean.Admin;
import com.exam.online.bean.LogInModel;
import com.exam.online.bean.Student;
import com.exam.online.bean.Teacher;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    Admin adminLogin(LogInModel logInModel);
    Teacher teacherLogin(LogInModel logInModel);
    Student studentLogin(LogInModel logInModel);
}
