package com.exam.online.controller;

import com.exam.online.bean.Admin;
import com.exam.online.bean.LogInModel;
import com.exam.online.bean.Student;
import com.exam.online.bean.Teacher;
import com.exam.online.service.LoginService;
import com.exam.online.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/admin")
    public AjaxResult adminLogin(@RequestBody LogInModel logInModel) {
        return data(loginService.adminLogin(logInModel));
    }

    @PostMapping("/teacher")
    public AjaxResult teacherLogin(@RequestBody LogInModel logInModel) {
        return data(loginService.teacherLogin(logInModel));
    }

    @PostMapping("/student")
    public AjaxResult studentLogin(@RequestBody LogInModel logInModel) {
        return data(loginService.studentLogin(logInModel));
    }

    private AjaxResult data(Object object) {
        return null != object ? AjaxResult.success("登陆成功", object) : AjaxResult.error("用户名或密码错误", null);
    }
}
