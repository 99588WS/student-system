package com.juzi.project.util;

import com.juzi.project.model.entity.Student;
import com.juzi.project.model.inner.ListNode;

/**
 * 链表工具类
 *
 * @author codejuzi
 * @CreateTime 2023/4/1
 */
public class LinkedListUtil {

    /**
     * 头节点
     */
    private static ListNode head;

    /**
     * 链表长度
     */
    private static int size;

    /**
     * 增节点
     *
     * @param listNode 待新增的结点
     */
    public static void insertListNode(ListNode listNode) {
        size++;
        if (head == null) {
            head = listNode;
            return;
        }
        ListNode curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(listNode);
    }


    /**
     * 删节点
     *
     * @param listNode 待删除的节点
     */
    public static void deleteListNode(ListNode listNode) {
        if (listNode == null || head == null) {
            return;
        }
        size--;
        ListNode curr = new ListNode(new Student(0), head);
        while (curr.getNext() != null) {
            if (StudentUtil.isSame(curr.getNext().getStudent(), listNode.getStudent())) {
                curr.setNext(curr.getNext().getNext());
            }
            curr = curr.getNext();
        }
    }

    /**
     * 改节点
     *
     * @param listNode 新的节点信息
     */
    public static void updateListNode(ListNode listNode) {
        if (listNode == null || head == null) {
            return;
        }
        ListNode curr = head;
        while (curr != null) {
            // TODO: 2023/4/1 判断StuId
            if (StudentUtil.isSame(curr.getStudent(), listNode.getStudent())) {
                curr.setStudent(listNode.getStudent());
            }
            curr = curr.getNext();
        }
    }

    /**
     * 获取学生信息（节点）
     *
     * @param stuId 学生id
     * @return student
     */
    public static Student selectStudent(Integer stuId) {
        // TODO: 2023/4/1 遍历比较
        return null;
    }

    /**
     * 输出链表
     */
    public static void showList() {
        if (head == null) {
            return;
        }
        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr);
            curr = curr.getNext();
        }
    }

    /**
     * 返回学生人数（链表长度）
     *
     * @return int
     */
    public static int getSize() {
        return size;
    }
}
