package com.zhangpingyang.springcloud_producer;

import org.junit.Test;

public class LongestPalindrome {
    @Test
    public void test1() {
        LongestPalindrome l = new LongestPalindrome();
        String babad = l.longestPalindrome("ac");
        System.out.println(babad);
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length < 2) {
            return s;
        }
        int[] xxx = new int[]{-1, -1};
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 == chars.length) {
                break;
            }
            char aChar = chars[i];
            char bChar = chars[i + 1];
            if (aChar == bChar) {
                int[] temp = xxx(chars, i, i + 1);
                if (temp[1] - temp[0] > xxx[1] - xxx[0]) {
                    xxx = temp;
                }
            }
            if (i + 2 == chars.length) {
                break;
            }
            char cChar = chars[i + 2];
            if (aChar == cChar) {
                int[] temp = xxx(chars, i, i + 2);
                if (temp[1] - temp[0] > xxx[1] - xxx[0]) {
                    xxx = temp;
                }
            }

        }
        if (xxx[0] == -1) {
            return s.substring(0, 1);
        }
        return s.substring(xxx[0], xxx[1] + 1);
    }

    private int[] xxx(char[] chars, int i, int j) {
        if (chars[i] == chars[j]) {
            if (i - 1 < 0 || j + 1 == chars.length) {
                return new int[]{i, j};
            }
            return xxx(chars, i - 1, j + 1);
        } else {
            return new int[]{i + 1, j - 1};
        }
    }

}
