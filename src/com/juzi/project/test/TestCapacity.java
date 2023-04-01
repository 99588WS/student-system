package com.juzi.project.test;

import com.juzi.project.controller.StudentController;
import com.juzi.project.model.entity.Student;
import com.juzi.project.util.StudentUtil;

import static com.juzi.project.db.StudentDataBase.STUDENT_DB;

/**
 * @author codejuzi
 */
public class TestCapacity {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        // region test add
        try {
            Student[] students = new Student[4];
            students[0] = new Student("zhangWu", 10, "101");
            students[1] = new Student("zhangWu", 11, "102");
            students[2] = new Student("zhangsan", 12, "201");
            students[3] = new Student("zhangLiu", 49, "202");
            studentController.addBatchStudent(students);
            int length = STUDENT_DB.length;
            System.out.println("length = " + length);
            StudentUtil.showStudentInfo();
            // 扩容
            StudentUtil.expendCapacity();
            length = STUDENT_DB.length;
            System.out.println("after expending, length = " + length);
            studentController.addStudent(new Student("zhangsan", 19, "101"));
            StudentUtil.showStudentInfo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
