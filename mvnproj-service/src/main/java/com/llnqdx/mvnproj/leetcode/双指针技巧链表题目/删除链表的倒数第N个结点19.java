package com.llnqdx.mvnproj.leetcode.双指针技巧链表题目;

public class 删除链表的倒数第N个结点19 {

    // 主函数
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第n个，要先找到倒数第 n+1 个几点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 返回链表中倒数第K个节点
    private ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n-k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        // p2 现在指向第 n-k+1 个节点，即倒数第 k 个节点
        return p2;
    }

    public static void main(String[] args) {
        删除链表的倒数第N个结点19 clazz = new 删除链表的倒数第N个结点19();
        int n = 2;

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode result = clazz.removeNthFromEnd(node, n);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
