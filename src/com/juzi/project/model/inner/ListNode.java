package com.juzi.project.model.inner;

import com.juzi.project.model.entity.Student;

/**
 * 链表节点
 *
 * @author codejuzi
 * @CreateTime 2023/4/1
 */
public class ListNode {

    private Student student;

    private ListNode next;

    public ListNode() {
    }

    public ListNode(Student student) {
        this.student = student;
    }

    public ListNode(Student student, ListNode next) {
        this.student = student;
        this.next = next;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "student=" + student.getStuAge() +
                ", next=" + next +
                '}';
    }
}
