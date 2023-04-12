package com.leetcode.accepted;

/**
 * hashmap where case-sensitive char is key, value is the frequency of character appearing in the input string
 * the temptation is to just sort since you would find out earlier if a center character appears or not but
 * that kicks up time complex to O(nlogn). I guess better to have a hashset of the characters accounted for
 * so you never re-check when you loop over a second time. do a modulo 2 == 1 check on all the values for the
 * central unpaired flag, and just count up the int (2) division of the values to start building your answer.
 *
 * this seems fairly readable
 *
 */
public class LongestPalindrome_409 {
    public static int longestPalindrome(String s) {
        int[] letters = new int[returnIndex('z') + 1];
        for (int i = 0; i < s.length(); i++) {
            int index = returnIndex(s.charAt(i));
            letters[index]++;
        }
        int carry = 0;
        int sum = 0;
        for (int i = 0; i < letters.length; i++) {
            if (carry == 0) {
                carry = (letters[i] % 2 == 1) ? 1 : 0;
            }
            sum = sum + 2 * (letters[i] / 2);
        }
        return sum + carry;
    }

    public static int returnIndex(char c) {
        if (c > 'Z') {
            return (c - 'A' - 5);
        } else {
            return (c - 'A');
        }
    }

}
