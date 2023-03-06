package com.juzi.project.service;

import com.juzi.project.entity.Student;

/**
 * 学生业务接口
 *
 * @author codejuzi
 */
public interface IStudentService {

    /**
     * 添加学生信息
     *
     * @param student 待添加学生信息
     * @return 学生id
     */
    Integer addStudent(Student student);
}
