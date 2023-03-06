package com.juzi.project.db;

import com.juzi.project.entity.SchoolClass;

import static com.juzi.project.constant.SchoolClassConstant.INITIAL_CLASS_NUMBER;

/**
 * 教室数据存储类
 *
 * @author codejuzi
 */
public class SchoolClassDataBase {

    public static SchoolClass[] schoolClasses = new SchoolClass[INITIAL_CLASS_NUMBER];

    static {
        schoolClasses[0] = new SchoolClass("101", 50);
        schoolClasses[1] = new SchoolClass("102", 49);
        schoolClasses[2] = new SchoolClass("201", 37);
        schoolClasses[3] = new SchoolClass("202", 40);
    }
}
