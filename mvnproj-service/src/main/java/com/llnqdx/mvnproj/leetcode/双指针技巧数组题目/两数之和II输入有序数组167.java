package com.llnqdx.mvnproj.leetcode.双指针技巧数组题目;

/**
 * @Description: 只要数组有序，就应该想到双指针技巧。这道题的解法有点类似二分查找，通过调节 left 和 right 就可以调整 sum 的大小：
 * @Author: maofujiang
 * @DateTime: 16:07 2024/7/27
 */
public class 两数之和II输入有序数组167 {

    int[] twoSum(int[] nums, int target) {
        // 一左一右两个指针相向而行
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                // 题目要求的索引是从 1 开始的
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++; // 让 sum 大一点
            } else if (sum > target) {
                right--; // 让 sum 小一点
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        两数之和II输入有序数组167 clazz = new 两数之和II输入有序数组167();
        int[] result = clazz.twoSum(numbers, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
