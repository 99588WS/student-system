package com.juzi.project.model.entity;

/**
 * 学校班级
 *
 * @author codejuzi
 */
public class SchoolClass {

    /**
     * 班级id
     */
    private String sClassId;

    /**
     * 班级人数
     */
    private Integer sClassMemNum;

    public SchoolClass() {
    }

    public SchoolClass(String sClassId, Integer sClassMemNum) {
        this.sClassId = sClassId;
        this.sClassMemNum = sClassMemNum;
    }

    public String getsClassId() {
        return sClassId;
    }

    public void setsClassId(String sClassId) {
        this.sClassId = sClassId;
    }

    public Integer getsClassMemNum() {
        return sClassMemNum;
    }

    public void setsClassMemNum(Integer sClassMemNum) {
        this.sClassMemNum = sClassMemNum;
    }

    @Override
    public String toString() {
        return "SchoolClass{" +
                "sClassId='" + sClassId + '\'' +
                ", sClassMemNum=" + sClassMemNum +
                '}';
    }
}
