package com.llnqdx.mvnproj.leetcode.双指针技巧数组题目;

/**
 * @Description: 高效解决这道题就要用到快慢指针技巧：
 * <p>
 * 我们让慢指针 slow 走在后面，快指针 fast 走在前面探路，找到一个不重复的元素就赋值给 slow 并让 slow 前进一步。
 * <p>
 * 这样，就保证了 nums[0..slow] 都是无重复的元素，当 fast 指针遍历完整个数组 nums 后，nums[0..slow] 就是整个数组去重之后的结果。
 * @Author: maofujiang
 * @DateTime: 14:25 2024/7/27
 */
public class 删除有序数组中的重复项26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }

        // 数组长度为索引 + 1
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        删除有序数组中的重复项26 clazz = new 删除有序数组中的重复项26();
        int i = clazz.removeDuplicates(nums);
        System.out.println(i);
    }
}
