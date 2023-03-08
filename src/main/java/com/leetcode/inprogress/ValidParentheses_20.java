package com.leetcode.inprogress;

public class ValidParentheses_20 {
    public static void main(String[] args){
        String s = "()[]{}";
        System.out.println(complement('{'));
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1 || len == 0) {
            return false;
        } else {
            int windowSpan = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                char ithchar = s.charAt(i);
                char complement = complement(ithchar);
                if (s.charAt(i+1) == complement) {
                    windowSpan--;
                    continue;
                } else if (s.charAt(i + windowSpan) == complement) {
                    windowSpan--;
                    continue;
                }
                for (int k = 0; i + k < s.length(); k++) {
                    if (i + k + 1 == s.length()) {
                        return false;
                    }
                    else if (s.charAt(i+k) == complement) {
                        windowSpan++;
                        break;
                    } else {
                        windowSpan++;
                    }
                }
            }
        }
        return true;
    }

    public static char complement(char c) {
        switch (c){
            case('{'): {
                return '}';
            }
            case('['): {
                return ']';
            }
            case('('): {
                return ')';
            }
        }
        return '0';
    }
}
