package com.leetcode.suboptimalsolutions;

import java.util.ArrayList;
import java.util.regex.Pattern;

/*

    need some way of determining whether numbers have appeared yet.
    check for negative needs to be began is false and char == '-'
    determine whether a character that appears is a number or not.
    can do c - '0' < 10 || c - '0' >= 0 to check for numbers
    arraylist can hold onto the digits
 */
public class Atoi {
    public static int myAtoi(String s) {
        boolean negative = false;
        boolean signAssigned = false;
        ArrayList<Integer> storedDigits = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && !signAssigned) { continue; }
            else if (c == '+' && !signAssigned) { signAssigned=true; continue; }
            else if (c == '-' && storedDigits.size() == 0 && !signAssigned) {
                signAssigned=true;
                negative=true;
                continue;
            }
            boolean digit = (c - '0' < 10 && c - '0' >= 0);
            if (storedDigits.size() > 0 && !digit) {
                break;
            } else if (digit && !signAssigned) {
                signAssigned = true;
                storedDigits.add(c - '0');
            } else if (signAssigned && !digit) {
                break;
            } else if (digit) {
                storedDigits.add(c - '0');
            } else {
                System.out.println("c = " + c + " . catching whatever comes here, though this shouldn't be reached");
                break;
            }
        }
        long num = 0;
        int res;
        // < 3, 4, 2> (10^2) * 3 -> (10^1) * 4 ->
        for (int i = 0; i < storedDigits.size(); i++) {
            num += Math.pow(10, storedDigits.size() - i - 1) * storedDigits.get(i);
        }
        if (negative) {
            num *= -1;
            res = (num < Integer.MIN_VALUE + 1) ? Integer.MIN_VALUE : (int) num;
        } else {
            res = (num >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : (int) num;
        }
        return res;
    }
}
