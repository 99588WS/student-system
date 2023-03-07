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

        checkStudent(student);

        // 生成id
        Integer stuId = StudentUtil.generateStuId();
        student.setStuId(stuId);

        // 判断是否需要扩容
        boolean flag = StudentUtil.checkMemory();
        if(flag) {
            // 需要扩容
            StudentUtil.expendCapacity();
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

    private void checkStuId(Integer stuId) {
        if (stuId <= 0 || stuId > StudentUtil.getStuId()) {
            throw new RuntimeException("学生id不合法！");
        }
    }

    private void checkStudent(Student student) {
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
}
