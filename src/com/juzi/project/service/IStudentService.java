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

    /**
     * 批量添加学生信息
     *
     * @param students 学生信息
     */
    void addBatchStudent(Student[] students);

    /**
     * 根据学生id删除学生信息
     *
     * @param stuId 学生id
     * @return true - 删除成功
     */
    boolean deleteStudentById(Integer stuId);

    /**
     * 批量删除学生信息
     *
     * @param stuIds 学生id
     * @return 是否删除成功
     */
    boolean deleteBatchStudent(Integer[] stuIds);

    /**
     * 根据学生id修改新的学生信息
     *
     * @param newStudent 新的学生信息
     * @return 是否修改成功
     */
    boolean updateStudentById(Student newStudent);

    /**
     * 根据学生id查询学生信息
     *
     * @param stuId 学生id
     * @return 匹配的学生信息
     */
    Student queryStudentById(Integer stuId);

    /**
     * 根据学生姓名模糊查询学生信息
     *
     * @param stuName 学生姓名
     * @return 匹配的学生信息
     */
    Student[] queryStudentByName(String stuName);
}
