package com.juzi.project.test;

import com.juzi.project.controller.StudentController;
import com.juzi.project.entity.Student;

import java.util.Arrays;

import static com.juzi.project.db.StudentDataBase.STUDENT_DB;

/**
 * 测试类
 *
 * @author codejuzi
 */
public class Test {

    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        // test add
        Student student = new Student("zhangsan", 18, "101");
        Integer stuId = studentController.addStudent(student);
        System.out.println("stuId = " + stuId);
        System.out.println(Arrays.toString(STUDENT_DB));

        try {
            Student student1 = new Student("zhangsan", 18, "101");
            studentController.addStudent(student1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
