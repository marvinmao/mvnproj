package com.llnqdx.mvnproj.leetcode.双指针技巧链表题目;

/**
 * @Description: 如果想一次遍历就得到中间节点，也需要耍点小聪明，使用「快慢指针」的技巧：
 * <p>
 * 我们让两个指针 slow 和 fast 分别指向链表头结点 head。
 * <p>
 * 每当慢指针 slow 前进一步，快指针 fast 就前进两步，这样，当 fast 走到链表末尾时，slow 就指向了链表中点。
 * @Author: maofujiang
 * @DateTime: 14:47 2024/7/27
 */
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
