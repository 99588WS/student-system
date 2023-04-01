package com.juzi.project.test;

import com.juzi.project.controller.StudentController;
import com.juzi.project.model.entity.Student;

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
        // region test add
        try {
            Student[] students = new Student[4];
            students[0] = new Student("zhangWu", 10, "101");
            students[1] = new Student("zhangWu", 11, "102");
            students[2] = new Student("zhangsan", 12, "201");
            students[3] = new Student("zhangLiu", 49, "202");
            studentController.addBatchStudent(students);
            System.out.println(Arrays.toString(STUDENT_DB));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // end region

        // region test delete
        boolean isSuccess = studentController.deleteStudentById(2);
        System.out.println(isSuccess ? "删除成功" : "删除失败");
        System.out.println(Arrays.toString(STUDENT_DB));

        // end region

        // region test update
        Student newStudent = new Student("lisi", 13,"202");
        newStudent.setStuId(3);
        isSuccess = studentController.updateStudentById(newStudent);
        System.out.println(isSuccess ? "修改成功" : "修改失败");
        System.out.println(Arrays.toString(STUDENT_DB));

        // end region

        // region test query
        Student student = studentController.queryStudentById(3);
        System.out.println("student = " + student);

        Student[] students = studentController.queryStudentByName("u");
        System.out.println(Arrays.toString(students));
        // end region
    }

}
