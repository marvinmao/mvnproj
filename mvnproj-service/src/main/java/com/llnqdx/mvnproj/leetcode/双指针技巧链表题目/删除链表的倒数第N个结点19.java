package com.llnqdx.mvnproj.leetcode.双指针技巧链表题目;

/**
 * @Description: 这个逻辑就很简单了，要删除倒数第 n 个节点，就得获得倒数第 n + 1 个节点的引用，可以用我们实现的 findFromEnd 来操作。
 * <p>
 * 不过注意我们又使用了虚拟头结点的技巧，也是为了防止出现空指针的情况，比如说链表总共有 5 个节点，题目就让你删除倒数第 5 个节点，也就是第一个节点，
 * 那按照算法逻辑，应该首先找到倒数第 6 个节点。但第一个节点前面已经没有节点了，这就会出错。
 * <p>
 * 但有了我们虚拟节点 dummy 的存在，就避免了这个问题，能够对这种情况进行正确的删除。
 * @Author: maofujiang
 * @DateTime: 14:43 2024/7/27
 */
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
