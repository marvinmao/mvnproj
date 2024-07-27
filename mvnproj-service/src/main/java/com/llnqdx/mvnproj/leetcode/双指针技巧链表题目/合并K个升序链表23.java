package com.llnqdx.mvnproj.leetcode.双指针技巧链表题目;

import java.util.PriorityQueue;

/**
 * @Description: 合并 k 个有序链表的逻辑类似合并两个有序链表，难点在于，如何快速得到 k 个节点中的最小节点，接到结果链表上？
 * <p>
 * 这里我们就要用到 优先级队列（二叉堆） 这种数据结构，把链表节点放入一个最小堆，就可以每次获得 k 个节点中的最小节点：
 * @Author: maofujiang
 * @DateTime: 16:44 2024/7/26
 */
public class 合并K个升序链表23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1), p = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                lists.length, (aa, bb) -> (aa.val - bb.val)
        );
        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            p = p.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        合并K个升序链表23 merge = new 合并K个升序链表23();
        ListNode[] lists = new ListNode[3];

        ListNode l0 = new ListNode(1);
        l0.next = new ListNode(4);
        l0.next.next = new ListNode(5);
        lists[0] = l0;

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        lists[1] = l1;

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(6);
        lists[2] = l2;

        ListNode result = merge.mergeKLists(lists);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
