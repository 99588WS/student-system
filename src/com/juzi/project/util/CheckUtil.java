package com.juzi.project.util;

import com.juzi.project.entity.SchoolClass;

import static com.juzi.project.db.SchoolClassDataBase.schoolClasses;

/**
 * 校验工具类
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
        for (SchoolClass schoolClass : schoolClasses) {
            if(schoolClass.getsClassId().equals(sClassId)) {
                return true;
            }
        }
        return false;
    }
}
