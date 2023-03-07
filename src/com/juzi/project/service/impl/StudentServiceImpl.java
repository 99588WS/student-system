package com.juzi.project.service.impl;

import com.juzi.project.entity.Student;
import com.juzi.project.service.IStudentService;
import com.juzi.project.util.StudentUtil;

import static com.juzi.project.db.StudentDataBase.STUDENT_DB;
import static com.juzi.project.util.CheckUtil.checkStuId;
import static com.juzi.project.util.CheckUtil.checkStudent;
import static com.juzi.project.util.StudentUtil.expendCapacity;

/**
 * 学生业务接口实现类
 *
 * @author codejuzi
 */
public class StudentServiceImpl implements IStudentService {
    @Override
    public Integer addStudent(Student student) {

        checkStudent(student);

        // 生成id
        Integer stuId = StudentUtil.generateStuId();
        student.setStuId(stuId);

        // 判断是否需要扩容
        boolean flag = StudentUtil.checkMemory();
        if(flag) {
            // 需要扩容
            expendCapacity();
        }

        // 保存数据库
        STUDENT_DB[stuId - 1] = student;

        return stuId;
    }

    @Override
    public void addBatchStudent(Student[] students) {
        for (Student student : students) {
            checkStudent(student);
            // 生成id
            Integer stuId = StudentUtil.generateStuId();
            student.setStuId(stuId);

            // 判断是否需要扩容
            boolean flag = StudentUtil.checkMemory();
            if(flag) {
                // 需要扩容
                expendCapacity();
            }

            // 保存数据库
            STUDENT_DB[stuId - 1] = student;
        }
    }

    @Override
    public boolean deleteStudentById(Integer stuId) {
        checkStuId(stuId);
        STUDENT_DB[stuId - 1] = null;
        return true;
    }

    @Override
    public boolean deleteBatchStudent(Integer[] stuIds) {
        try {
            for (Integer stuId : stuIds) {
                checkStuId(stuId);
                STUDENT_DB[stuId - 1] = null;
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }



    @Override
    public boolean updateStudentById(Student newStudent) {
        Integer stuId = newStudent.getStuId();

        checkStuId(stuId);
        checkStudent(newStudent);

        // 修改信息
        STUDENT_DB[stuId - 1] = newStudent;

        return true;
    }

    @Override
    public Student queryStudentById(Integer stuId) {
        checkStuId(stuId);
        return STUDENT_DB[stuId - 1];
    }

    @Override
    public Student[] queryStudentByName(String stuName) {
        if(stuName == null) {
            throw new RuntimeException("stuName is null!");
        }
        Student[] students = new Student[STUDENT_DB.length];
        int count = 0;
        for (Student student : STUDENT_DB) {
            if(student != null) {
                String name = student.getStuName();
                if (name.contains(stuName)) {
                    students[count++] = student;
                }
            }
        }
        return students;
    }
}
