package com.zhangpingyang.eureka_server;

import org.junit.Test;

/**
 * @Author: Zhang Pingyang
 * @Date: 2019/10/17 17:17
 */
public class LeetCodeTest {
    @Test
    public void test1() {
        Solution1 s = new Solution1();
        String str = "cbbd";
        String s1 = s.longestPalindrome(str);
        System.out.println(s1);
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     */
    class Solution1 {
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            int max[] = new int[]{1,-1, -1};
            for (int i = 1; i < chars.length; i++) {
                int[] palindrome = findPalindrome(chars, i);
                if (palindrome[0] > max[0]) {
                    max = palindrome;
                }
            }
            StringBuilder sb = new StringBuilder();
            return s.substring(max[1], max[2] + 1);
        }
        private int[] findPalindrome(char[] chars, int index) {
            if (index == chars.length - 1) {
                return new int[]{1, index, index};
            }
            if (chars[index] == chars[index + 1]) {
                int[] reins = xxx(chars, index - 1, index + 2);
                return new int[]{reins[1] - reins[0] + 1, reins[0], reins[1]};
            }
            if (chars[index - 1] == chars[index + 1]) {
                int[] reins = xxx(chars, index - 1, index + 2);
                return new int[]{reins[1] - reins[0] + 1, reins[0], reins[1]};
            }
            return new int[]{1, index, index};
        }

        private int[] xxx(char[] chars, int i, int j) {
            if (chars[i] == chars[j]) {
                return xxx(chars, chars[i - 1], chars[j + 1]);
            } else {
                return new int[]{i+1, j-1};
            }
        }


    }
}
