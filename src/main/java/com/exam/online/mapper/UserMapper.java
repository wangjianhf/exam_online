package com.exam.online.mapper;

import com.exam.online.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 用户登录
     */
    User queryUser(User user);
}
