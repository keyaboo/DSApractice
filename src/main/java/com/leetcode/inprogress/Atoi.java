package com.leetcode.inprogress;

public class Atoi {
    public static int myAtoi(String s) {
        boolean negative = false;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') { continue; };

        }
        return (negative) ? -num : num;
    }
}
