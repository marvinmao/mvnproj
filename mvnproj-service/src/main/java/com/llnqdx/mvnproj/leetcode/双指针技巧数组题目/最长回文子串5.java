package com.llnqdx.mvnproj.leetcode.双指针技巧数组题目;

/**
 * @Description: 找回文串的难点在于，回文串的的长度可能是奇数也可能是偶数，解决该问题的核心是从中心向两端扩散的双指针技巧。
 * <p>
 * 如果回文串的长度为奇数，则它有一个中心字符；如果回文串的长度为偶数，则可以认为它有两个中心字符。所以我们可以先实现这样一个函数：palindrome(String s, int l, int r)
 *
 * 这样，如果输入相同的 l 和 r，就相当于寻找长度为奇数的回文串，如果输入相邻的 l 和 r，则相当于寻找长度为偶数的回文串。
 *
 * 那么回到最长回文串的问题，解法的大致思路就是：
 *
 *
 * @Author: maofujiang
 * @DateTime: 16:39 2024/7/27
 */
public class 最长回文子串5 {

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    // 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
    String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 双指针，向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }
}
