package com.zhangpingyang.springcloud_producer;

import org.junit.Test;

public class LeetCodeTest {
    @Test
    public void test1() {
        Solution1 s = new Solution1();
        String babad = s.longestPalindrome("babad");

    }
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
            return s.substring(max[1], max[2] + 1);
        }
        private int[] findPalindrome(char[] chars, int index) {
            if (index + 2 == chars.length - 1) {
                return new int[]{1, index, index};
            }
            if (chars[index] == chars[index + 1]) {
                int[] reins = xxx(chars, index - 1, index + 2);
                return new int[]{reins[1] - reins[0] + 1, reins[0], reins[1]};
            }
            if (chars[index] == chars[index + 2]) {
                int[] reins = xxx(chars, index - 1, index + 3);
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
