package com.juzi.project.db;

import com.juzi.project.model.entity.SchoolClass;

import static com.juzi.project.constant.SchoolClassConstant.INITIAL_CLASS_NUMBER;

/**
 * 教室数据存储类
 *
 * @author codejuzi
 */
public class SchoolClassDataBase {

    public static SchoolClass[] SCHOOL_CLASS_DB = new SchoolClass[INITIAL_CLASS_NUMBER];

    static {
        SCHOOL_CLASS_DB[0] = new SchoolClass("101", 50);
        SCHOOL_CLASS_DB[1] = new SchoolClass("102", 49);
        SCHOOL_CLASS_DB[2] = new SchoolClass("201", 37);
        SCHOOL_CLASS_DB[3] = new SchoolClass("202", 40);
    }
}
