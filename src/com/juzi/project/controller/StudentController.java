package com.juzi.project.controller;

import com.juzi.project.entity.Student;
import com.juzi.project.service.IStudentService;
import com.juzi.project.service.impl.StudentServiceImpl;

/**
 * 学生管理接口
 *
 * @author codejuzi
 */
public class StudentController {

    private IStudentService studentService = new StudentServiceImpl();

    /**
     * 添加学生信息
     *
     * @param student 待添加学生信息
     * @return 学生id
     */
    public Integer addStudent(Student student) {
        return studentService.addStudent(student);
    }

    /**
     * 批量添加学生信息
     *
     * @param students 学生信息
     */
    public void addBatchStudent(Student[] students) {
        // TODO: 2023/3/6 调用接口
    }

    /**
     * 根据学生id删除学生信息
     *
     * @param stuId 学生id
     */
    public void deleteStudentById(Integer stuId) {

    }

    /**
     * 批量删除学生信息
     *
     * @param stuIds 学生id
     */
    public void deleteBatchStudent(Integer[] stuIds) {
        // TODO: 2023/3/6 调用接口
    }

    /**
     * 根据学生id修改新的学生信息
     *
     * @param newStudent 新的学生信息
     */
    public void updateStudentById(Student newStudent) {

    }

    /**
     * 查询所有学生信息
     *
     * @return 所有学生信息
     */
    public Student[] listStudents() {
         return null;
    }

    /**
     * 根据学生id查询学生信息
     *
     * @param stuId 学生id
     * @return 匹配的学生信息
     */
    public Student queryStudentById(Integer stuId) {
        return null;
    }

    /**
     * 根据学生姓名模糊查询学生信息
     *
     * @param stuName 学生姓名
     * @return 匹配的学生信息
     */
    public Student[] queryStudentByName(String stuName) {
        return null;
    }

}
