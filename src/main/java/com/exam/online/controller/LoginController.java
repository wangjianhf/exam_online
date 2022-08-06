package com.exam.online.controller;

import com.exam.online.bean.User;
import com.exam.online.service.LoginService;
import com.exam.online.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public AjaxResult userLogin(@RequestBody User user) {
        return data(loginService.login(user));
    }

    private AjaxResult data(Object object) {
        return null != object ? AjaxResult.success("登陆成功", object) : AjaxResult.error("用户名或密码错误", null);
    }
}
