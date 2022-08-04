package com.exam.online.mapper;


import com.exam.online.bean.LogInModel;
import org.apache.ibatis.annotations.Mapper;
import com.exam.online.bean.Admin;
import com.exam.online.bean.Student;
import com.exam.online.bean.Teacher;

/**
 * 管理员信息操作类,通过mybatis获取实现类
 */
@Mapper
public interface IAdminMapper {
    /**
     * 用于判断管理员账户是否存在
     *
     * @param logInModel 管理员账号
     * @return 如果查询到返回对应管理员账户的实体类, 如果返回值为:null说明没有找到
     */
    Admin findAccount(LogInModel logInModel);

    /**
     * 查询所有学生信息
     *
     * @return 返回所有学生信息
     */
    Student[] findAllStudent();

    /**
     * 查询所有教师信息
     *
     * @return 返回所有教师信息
     */
    Teacher[] findAllTeacher();

    /**
     * 添加学生信息
     */
    void addStudent(Student student);

    /**
     * 添加教师信息
     */
    void addTeacher(Teacher teacher);

    /**
     * 删除指定编号的学生id
     */
    void removeStudent(Integer stuId);

    /**
     * 删除指定的教师信息
     *
     * @param teaId 教师编号
     */
    void removeTeacher(Integer teaId);


    /**
     * 删除指定的教师编号范围
     */
    void removeTeacherSet(Integer startTeaId, Integer endTeaId);

    /**
     * 删除指定的学生编号范围
     */
    void removeStudentSet(Integer startStuId, Integer endStuId);

    /**
     * 修改学生信息
     *
     * @param student
     */
    void updateStudent(Student student);

    /**
     * 修改教师信息
     *
     * @param teacher
     */
    void updateTeacher(Teacher teacher);

    /**
     * 查询所有学生数量
     *
     * @return 返回学生数量
     */
    Integer queryStudentSum();

    /**
     * 查询所有教师数量
     *
     * @return 返回教师数量
     */
    Integer queryTeacherSum();


    /**
     * 查询所有学生的id
     *
     * @return 返回学生数量
     */
    Integer[] queryStudentIdSum();

    /**
     * 查询所有教师的id
     *
     * @return 返回教师数量
     */
    Integer[] queryTeacherIdSum();
    
}