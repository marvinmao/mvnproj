package com.llnqdx.mvnproj.leetcode.双指针技巧数组题目;

/**
 * @Description: 题目要求我们把 nums 中所有值为 val 的元素原地删除，依然需要使用快慢指针技巧：
 * <p>
 * 如果 fast 遇到值为 val 的元素，则直接跳过，否则就赋值给 slow 指针，并让 slow 前进一步。
 * <p>
 * 注意这里和有序数组去重的解法有一个细节差异，我们这里是先给 nums[slow] 赋值然后再给 slow++，这样可以保证 nums[0..slow-1] 是不包含值为 val 的元素的，最后的结果数组长度就是 slow。
 * @Author: maofujiang
 * @DateTime: 14:25 2024/7/27
 */
public class 移除元素27 {

    int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int val = 3;
        移除元素27 clazz = new 移除元素27();
        int i = clazz.removeElement(nums, 3);
        System.out.println(i);
    }
}
