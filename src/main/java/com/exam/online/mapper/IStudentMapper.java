package com.exam.online.mapper;

import com.exam.online.bean.LogInModel;
import com.exam.online.bean.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生信息操作类,通过mybatis获取实现类
 */
@Mapper
public interface IStudentMapper {

    /**
     * 用于判断学生账户是否存在
     *
     * @param logInModel
     * @return 如果查询到返回对应学生账户的实体类, 如果返回值为:null说明没有找到
     */
    Student findAccount(LogInModel logInModel);

    /**
     * 查询学生id是否存在
     *
     * @param userid
     * @return
     */
    Student findUser(Integer userid);
}
