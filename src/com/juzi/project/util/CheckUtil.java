package com.juzi.project.util;

import com.juzi.project.model.entity.SchoolClass;
import com.juzi.project.model.entity.Student;

import static com.juzi.project.db.SchoolClassDataBase.SCHOOL_CLASS_DB;

/**
 * 校验工具类
 *
 * @author codejuzi
 */
public class CheckUtil {

    /**
     * 校验教室id是否合法
     *
     * @param sClassId 教室id
     * @return true - 合法， false - 非法
     */
    public static boolean checkSchoolClassId(String sClassId) {
        for (SchoolClass schoolClass : SCHOOL_CLASS_DB) {
            if (schoolClass.getsClassId().equals(sClassId)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 校验student id是否合法
     *
     * @param stuId 学生id
     */
    public static void checkStuId(Integer stuId) {
        if (stuId <= 0 || stuId > StudentUtil.getStuId()) {
            throw new RuntimeException("学生id不合法！");
        }
    }

    /**
     * 校验学生基本信息是否合法
     *
     * @param student 学生信息
     */
    public static void checkStudent(Student student) {
        String stuName = student.getStuName();
        Integer stuAge = student.getStuAge();
        String sClassId = student.getsClassId();

        if (stuName == null || "".equals(stuName)) {
            throw new RuntimeException("学生姓名不合法！");
        }

        if (stuAge == null || stuAge < 0 || stuAge > 50) {
            throw new RuntimeException("学生年龄不合法");
        }

        if (sClassId == null || !CheckUtil.checkSchoolClassId(sClassId)) {
            throw new RuntimeException("教室id不合法");
        }
    }

    /**
     * 前校验
     *
     * @param condition true - 非法
     */
    public static void preCheck(boolean condition) {
        if(condition) {
            throw new RuntimeException("操作非法！");
        }
    }
}
