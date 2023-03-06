package com.juzi.project.util;

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
}
