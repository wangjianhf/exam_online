package com.exam.online.service.Impl;


import com.exam.online.bean.Admin;
import com.exam.online.bean.LogInModel;
import com.exam.online.bean.Student;
import com.exam.online.bean.Teacher;
import com.exam.online.mapper.IAdminMapper;
import com.exam.online.mapper.IStudentMapper;
import com.exam.online.mapper.ITeacherMapper;
import com.exam.online.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private IAdminMapper adminMapper;

    @Autowired
    private ITeacherMapper teacherMapper;

    @Autowired
    private IStudentMapper studentMapper;

    @Override
    public Admin adminLogin(LogInModel logInModel) {

        return adminMapper.findAccount(logInModel);
    }

    @Override
    public Teacher teacherLogin(LogInModel logInModel) {
        return teacherMapper.findAccount(logInModel);
    }

    @Override
    public Student studentLogin(LogInModel logInModel) {
        return studentMapper.findAccount(logInModel);
    }
}
