package com.exam.online.mapper;

import com.exam.online.bean.LogInModel;
import com.exam.online.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
 * 教师信息操作类,通过mybatis获取实现类
 */
@Mapper
public interface ITeacherMapper {

    /**
     * 用于判断教师账户是否存在
     * @param logInModel
     * @return 如果查询到返回对应教师账户的实体类,如果返回值为:null说明没有找到
     */
    Teacher findAccount(LogInModel logInModel);

    /**
     * 查询教师id是否存在
     * @return
     */
    Teacher findTeaId(Integer teaId);
}
