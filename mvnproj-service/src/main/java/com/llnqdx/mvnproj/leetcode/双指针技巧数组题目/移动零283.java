package com.llnqdx.mvnproj.leetcode.双指针技巧数组题目;

/**
 * @Description: 题目让我们将所有 0 移到最后，其实就相当于移除 nums 中的所有 0，然后再把后面的元素都赋值为 0 即可。
 * <p>
 * 所以我们可以复用上一题的 removeElement 函数：
 * @Author: maofujiang
 * @DateTime: 14:25 2024/7/27
 */
public class 移动零283 {

    void moveZeroes(int[] nums) {
        // 去除 nums 中的所有 0，返回不含 0 的数组长度
        int p = removeElement(nums, 0);
        // 将 nums[p..] 的元素赋值为 0
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }

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
        移动零283 clazz = new 移动零283();
        int i = clazz.removeElement(nums, 3);
        System.out.println(i);
    }
}
