package com.llnqdx.mvnproj.leetcode.双指针技巧链表题目;

/**
 * @Description: 形象地理解，这个算法的逻辑类似于拉拉链，l1, l2 类似于拉链两侧的锯齿，指针 p 就好像拉链的拉索，将两个有序链表合并；
 * 或者说这个过程像蛋白酶合成蛋白质，l1, l2 就好比两条氨基酸，而指针 p 就好像蛋白酶，将氨基酸组合成蛋白质。
 * <p>
 * 代码中还用到一个链表的算法题中是很常见的「虚拟头结点」技巧，也就是 dummy 节点。你可以试试，如果不使用 dummy 虚拟节点，代码会复杂一些，需要额外处理指针 p 为空的情况。
 * 而有了 dummy 节点这个占位符，可以避免处理空指针的情况，降低代码的复杂性。
 * @Author: maofujiang
 * @DateTime: 14:41 2024/7/27
 */
public class 分隔链表86 {

    ListNode partition(ListNode head, int x) {
        // 存放小于 x 的链表的虚拟头结点
        ListNode dummy1 = new ListNode(-1);
        // 存放大于等于 x 的链表的虚拟头结点
        ListNode dummy2 = new ListNode(-1);
        // p1, p2 指针负责生成结果链表
        ListNode p1 = dummy1, p2 = dummy2;
        // p 负责遍历原链表，类似合并两个有序链表的逻辑
        // 这里是将一个链表分解成两个链表
        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            // 不能直接让 p 指针前进，
            // p = p.next
            // 断开原链表中的每个节点的 next 指针
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        // 连接两个链表
        p1.next = dummy2.next;

        return dummy1.next;
    }

    public static void main(String[] args) {
        int x = 3;
        ListNode l = new ListNode(1);
        l.next = new ListNode(4);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(2);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(2);

        分隔链表86 partition = new 分隔链表86();
        ListNode result = partition.partition(l, x);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
