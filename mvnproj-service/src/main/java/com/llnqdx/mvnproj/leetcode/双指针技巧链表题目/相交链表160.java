package com.llnqdx.mvnproj.leetcode.双指针技巧链表题目;


/**
 * @Description: 如果用两个指针 p1 和 p2 分别在两条链表上前进，并不能同时走到公共节点，也就无法得到相交节点 c1。
 * <p>
 * 解决这个问题的关键是，通过某些方式，让 p1 和 p2 能够同时到达相交节点 c1。
 * <p>
 * 所以，我们可以让 p1 遍历完链表 A 之后开始遍历链表 B，让 p2 遍历完链表 B 之后开始遍历链表 A，这样相当于「逻辑上」两条链表接在了一起。
 * <p>
 * 如果这样进行拼接，就可以让 p1 和 p2 同时进入公共部分，也就是同时到达相交节点 c1：
 * @Author: maofujiang
 * @DateTime: 14:50 2024/7/27
 */
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
