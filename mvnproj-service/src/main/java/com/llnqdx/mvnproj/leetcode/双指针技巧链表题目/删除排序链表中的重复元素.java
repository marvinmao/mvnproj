package com.llnqdx.mvnproj.leetcode.双指针技巧链表题目;

/**
 * @Description: 其实和数组去重是一模一样的，唯一的区别是把数组赋值操作变成操作指针而已，你对照着之前的代码来看：
 * @Author: maofujiang
 * @DateTime: 14:51 2024/7/27
 */
public class 删除排序链表中的重复元素 {

    ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                // nums[slow] = nums[fast];
                slow.next = fast;
                // slow++;
                slow = slow.next;
            }
            // fast++
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }
}
