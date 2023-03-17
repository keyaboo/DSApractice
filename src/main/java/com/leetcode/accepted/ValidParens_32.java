package com.leetcode.accepted;

import java.util.Stack;

/**
 * I'm dumb - gonna use a queue here!
 */
public class ValidParens_32 {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {
        Stack<Character> stck = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character complement = (Character) complement(c);
            if (!stck.isEmpty() && stck.peek() == complement) {
                stck.pop();
            } else {
                stck.push(c);
            }
        }
        if (!stck.isEmpty()) {
            return false;
        } return true;
    }

    public static char complement(char c) {
        switch(c) {
            case(')'):
                return '(';
            case('}'):
                return '{';
            case(']'):
                return '[';
        }
        return '0';
    }
}