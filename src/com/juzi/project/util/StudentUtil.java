package com.juzi.project.util;

import com.juzi.project.entity.Student;

import static com.juzi.project.constant.StudentConstant.*;
import static com.juzi.project.db.StudentDataBase.STUDENT_DB;

/**
 * 学生工具类
 *
 * @author codejuzi
 */
public class StudentUtil {

    private static Integer STU_ID = 1;

    public static Integer generateStuId() {
        return STU_ID++;
    }

    public static Integer getStuId() {
        return STU_ID;
    }

    /**
     * 检查是否需要扩容
     *
     * @return true - 需要扩容
     */
    public static boolean checkMemory() {
        return STU_ID >= EXPEND_CAPACITY_RATE * INITIAL_NUMBER;
    }

    /**
     * 扩容函数
     */
    public static void expendCapacity() {
        CURRENT_NUMBER = (int) (CURRENT_NUMBER * EXPEND_CAPACITY_TIMES);
        Student[] newStudents = new Student[CURRENT_NUMBER];
        // 复制原有数据
        System.arraycopy(STUDENT_DB, 0, newStudents, 0, STUDENT_DB.length);
        // 更改数据库指向
        STUDENT_DB = newStudents;
    }

    /**
     * 展示学生信息函数
     */
    public static void showStudentInfo() {
        for (Student student : STUDENT_DB) {
            if (student == null) {
                continue;
            }
            System.out.println(student);
        }
    }

    /**
     * 传入的学生信息存在并且有更改
     *
     * @param newStudent 新的学生信息
     * @return !null && !same
     */
    public static boolean isSame(Student newStudent) {
        if (newStudent == null) {
            return false;
        }
        Integer stuId = newStudent.getStuId();
        String stuName = newStudent.getStuName();
        Integer stuAge = newStudent.getStuAge();
        String sClassId = newStudent.getsClassId();

        // 拿到原有的学生信息
        CheckUtil.checkStuId(stuId);
        Student oldStudent = STUDENT_DB[stuId];
        return !oldStudent.getStuAge().equals(stuAge)
                || !oldStudent.getStuName().equals(stuName)
                || !oldStudent.getsClassId().equals(sClassId);
    }
}
