package com.leetcode.badstrategies;

/**
 * I am fucking retarded [ (()()) or this ((()(()))) ] is what they mean by "valid" parentheses.
 *
 * missed edge case: e.g. ))))))(((((( has zero valid
 * () is the other, nothing moves and have to return 1 before the counter is adjusted.
 */
public class LongestValidParens_32 {
    public static void main(String[] args){
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int len = s.length();
        if (len < 2) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        int counter = 0;
        boolean leftStopped = false;
        boolean rightStopped = false;
        while (left < right) {
            if (s.charAt(left) == '(' && !leftStopped) {
                leftStopped = true;
            }
            if (s.charAt(right) == ')' && !rightStopped) {
                rightStopped = true;
            }
            if ((right - left == 1) && !(leftStopped && rightStopped)) {
                return 0;
            } else if ((right - left == 1) && (leftStopped && rightStopped)) {
                return 1;
            }
            if (leftStopped && rightStopped) {
                return counter + right - left;
            } else if (leftStopped && !rightStopped) {
                right--;
                counter++;
            } else if (rightStopped && !leftStopped) {
                left++;
                counter++;
            } else if (!leftStopped && !rightStopped) {
                left++;
                right--;
                counter = counter + 2;
            }
        }
        return 0;
    }

}
