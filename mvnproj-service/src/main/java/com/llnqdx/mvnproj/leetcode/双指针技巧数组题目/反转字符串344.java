package com.llnqdx.mvnproj.leetcode.双指针技巧数组题目;

public class 反转字符串344 {

    void reverseString(char[] s) {
        // 一左一右两个指针相向而行
        int left = 0, right = s.length - 1;
        while (left < right) {
            // 交换 s[left] 和 s[right]
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        反转字符串344 clazz = new 反转字符串344();
        clazz.reverseString(s);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
