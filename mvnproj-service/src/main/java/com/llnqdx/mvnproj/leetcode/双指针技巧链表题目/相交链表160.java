package com.llnqdx.mvnproj.leetcode.双指针技巧链表题目;

public class 相交链表160 {

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }

        // 两个链表没有相交点，相当于 c1 节点是 null 空指针，可以正确返回 null

        return p1;
    }

    public static void main(String[] args) {

        相交链表160 clazz = new 相交链表160();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(7);
        l2.next.next.next.next = new ListNode(8);

        ListNode result = clazz.getIntersectionNode(l1, l2);
        System.out.println(result);
    }
}
