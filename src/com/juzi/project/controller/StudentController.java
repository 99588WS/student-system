package com.juzi.project.controller;

import com.juzi.project.model.entity.Student;
import com.juzi.project.service.IStudentService;
import com.juzi.project.service.impl.StudentServiceImpl;
import com.juzi.project.util.CheckUtil;
import com.juzi.project.util.StringUtil;
import com.juzi.project.util.StudentUtil;

import static com.juzi.project.db.StudentDataBase.STUDENT_DB;

/**
 * 学生管理接口
 *
 * @author codejuzi
 */
public class StudentController {

    private static final IStudentService studentService = new StudentServiceImpl();

    /**
     * 添加学生信息
     *
     * @param student 待添加学生信息
     * @return 学生id
     */
    public Integer addStudent(Student student) {
        CheckUtil.preCheck(student == null);
        return studentService.addStudent(student);
    }

    /**
     * 批量添加学生信息
     *
     * @param students 学生信息
     */
    public void addBatchStudent(Student[] students) {
        CheckUtil.preCheck(students == null);
        studentService.addBatchStudent(students);
    }

    /**
     * 根据学生id删除学生信息
     *
     * @param stuId 学生id
     * @return 是否删除成功
     */
    public boolean deleteStudentById(Integer stuId) {
        CheckUtil.checkStuId(stuId);
        return studentService.deleteStudentById(stuId);
    }

    /**
     * 批量删除学生信息
     *
     * @param stuIds 学生id
     * @return 是否删除成功
     */
    public boolean deleteBatchStudent(Integer[] stuIds) {
        CheckUtil.preCheck(stuIds == null);
        return studentService.deleteBatchStudent(stuIds);
    }

    /**
     * 根据学生id修改新的学生信息
     *
     * @param newStudent 新的学生信息
     * @return 是否修改成功
     */
    public boolean updateStudentById(Student newStudent) {
        CheckUtil.preCheck(StudentUtil.isSame(newStudent));
        return studentService.updateStudentById(newStudent);
    }

    /**
     * 查询所有学生信息
     * todo 管理员使用
     *
     * @return 所有学生信息
     */
    public Student[] listStudents() {
        return STUDENT_DB;
    }

    /**
     * 根据学生id查询学生信息
     *
     * @param stuId 学生id
     * @return 匹配的学生信息
     */
    public Student queryStudentById(Integer stuId) {
        CheckUtil.checkStuId(stuId);
        return studentService.queryStudentById(stuId);
    }

    /**
     * 根据学生姓名模糊查询学生信息
     *
     * @param stuName 学生姓名
     * @return 匹配的学生信息
     */
    public Student[] queryStudentByName(String stuName) {
        CheckUtil.preCheck(!StringUtil.isNotBlank(stuName));
        return studentService.queryStudentByName(stuName);
    }

}
