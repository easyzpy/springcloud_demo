package com.zhangpingyang.eureka_server;

import org.junit.Test;

/**
 * @Author: Zhang Pingyang
 * @Date: 2019/10/18 11:42
 */
public class LeetCodeTest3 {
    @Test
    public void test1() {
        String regex = "/^[\\w\\~\\!\\@\\$\\^\\*\\(\\)\\_\\`\\-\\[\\]\\\\\\|\\;\\'\\,\\.\\:\\\"\\<\\>]+$/";

        regex = "/^[\\+\\-]?\\d+$/";




//        String s = "0123456789";
//        for (char c : s.toCharArray()) {
//            System.out.println((int)c);
//        }
    }

    @Test
    public void test2() {
        LeetCodeTest3 l = new LeetCodeTest3();
        int i = l.myAtoi("4193 with words");
    }


    public int myAtoi(String str) {
//        if ("".equals(str) || str == null||"-".equals(str)) {
//            return 0;
//        }
//        char[] chars = str.toCharArray();
//        boolean isBegin = false;
//        boolean isFu = false;
//        StringBuilder result = new StringBuilder();
//        for(char c:chars){
//
//            if (!isBegin && (c > '9' || c < '0') && c != '-' && c != ' ') {
//                return 0;
//            }
//            if (c == ' ') {
//                continue;
//            }
//            if (c == '-' && !isFu) {
//                isBegin = true;
//                isFu = true;
//            } else if(c == '+' ){
//
//            }else if (c == '-') {
//                return 0;
//            } else if (isBegin && (c > '9' || c < '0')) {
//                break;
//            } else {
//                isBegin = true;
//                result.append(c);
//            }
//        }
//        if (isFu) {
//            result.insert(0,"-");
//        }
//        try {
//            return Integer.parseInt(result.toString());
//        } catch (Exception e) {
//            if (isFu) {
//                return Integer.MIN_VALUE;
//            }
//            return Integer.MAX_VALUE;
//        }
        return 1;
    }
}
