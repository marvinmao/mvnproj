package com.llnqdx.mvnproj.leetcode.双指针技巧链表题目;

public class 链表的中间结点876 {

    ListNode middleNode(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode fast = head, slow = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 慢指针指向中点
        return slow;
    }

    public static void main(String[] args) {
        链表的中间结点876 clazz = new 链表的中间结点876();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode result = clazz.middleNode(node);
        System.out.println(result.val);
    }
}
