package com.juzi.project.service.impl;

import com.juzi.project.entity.Student;
import com.juzi.project.service.IStudentService;
import com.juzi.project.util.CheckUtil;
import com.juzi.project.util.StudentUtil;

import static com.juzi.project.db.StudentDataBase.STUDENT_DB;

/**
 * 学生业务接口实现类
 *
 * @author codejuzi
 */
public class StudentServiceImpl implements IStudentService {
    @Override
    public Integer addStudent(Student student) {
        String stuName = student.getStuName();
        Integer stuAge = student.getStuAge();
        String sClassId = student.getsClassId();

        if(stuName == null || "".equals(stuName)) {
            throw new RuntimeException("学生姓名不合法！");
        }

        if(stuAge == null || stuAge < 0 || stuAge > 50) {
            throw new RuntimeException("学生年龄不合法");
        }

        if(sClassId == null || !CheckUtil.checkSchoolClassId(sClassId)) {
            throw new RuntimeException("教室id不合法");
        }

        // 生成id
        Integer stuId = StudentUtil.generateStuId();
        student.setStuId(stuId);

        // 保存数据库
        STUDENT_DB[stuId - 1] = student;

        return stuId;
    }
}
