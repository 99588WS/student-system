package com.juzi.project.model.entity;

import java.util.Objects;

/**
 * 学生信息类
 *
 * @author codejuzi
 */
public class Student {
    /**
     * 学生id
     */
    private Integer stuId;

    /**
     * 学生姓名
     */
    private String stuName;

    /**
     * 学生年龄
     */
    private Integer stuAge;

    /**
     * 所在班级id
     */
    private String sClassId;

    public Student() {
    }

    public Student(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public Student(String stuName, Integer stuAge, String sClassId) {
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.sClassId = sClassId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getsClassId() {
        return sClassId;
    }

    public void setsClassId(String sClassId) {
        this.sClassId = sClassId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                ", sClassId='" + sClassId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(stuId, student.stuId) && Objects.equals(stuName, student.stuName) && Objects.equals(stuAge, student.stuAge) && Objects.equals(sClassId, student.sClassId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, stuName, stuAge, sClassId);
    }
}
