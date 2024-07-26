package com.llnqdx.mvnproj.leetcode;

import java.util.PriorityQueue;

public class 合并K个升序链表23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }

        ListNode r = new ListNode(-1), p = r;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                lists.length, (aa, bb) -> (aa.val - bb.val)
        );
        for(ListNode head : lists) {
            if(head != null) {
                queue.add(head);
            }
        }

        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            if(node.next != null) {
                queue.add(node.next);
            }
            p = p.next;
        }

        return r.next;
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
