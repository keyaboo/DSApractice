package com.leetcode.inprogress;

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
            boolean adjustedleft = false;
            boolean adjustedright = false;
            if (s.charAt(left) == '(' && !leftStopped) {
                System.out.println("reached?");
                leftStopped = true;
                adjustedleft = true;
                counter++;
                left++;

            }
            if (s.charAt(right) == ')' && !rightStopped) {
                System.out.println("");
                rightStopped = true;
                adjustedright = true;
                counter++;
                right--;
            }
            if (leftStopped && rightStopped) {
                left++;
                counter++;
            } else if (leftStopped && !adjustedleft) {
                left++;
                counter++;
            } else if (rightStopped && !adjustedright) {
                right--;
                counter++;
            }
        }
        return counter-1;
    }

}
