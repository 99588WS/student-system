package com.juzi.project.test;

import com.juzi.project.model.entity.Student;
import com.juzi.project.model.inner.ListNode;
import com.juzi.project.util.LinkedListUtil;

/**
 * 链表测试类
 *
 * @author codejuzi
 * @CreateTime 2023/4/1
 */
public class LinkedListTest {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            ListNode listNode = new ListNode(new Student(i + 1));
            LinkedListUtil.insertListNode(listNode);
        }
        LinkedListUtil.showList();
        ListNode listNode = new ListNode(new Student(1));
        LinkedListUtil.deleteListNode(listNode);
        System.out.println("=========================================");
        LinkedListUtil.showList();
    }

}
