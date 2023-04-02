package com.leetcode.badstrategies;

import java.util.Arrays;

/**
 * my thought here is to turn these strings into integer arrays, sort and compare
 */
public class ValidAnagram_242 {
    public static void main(String[] args){
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s,t));
    }

    public static int[] convertToSortedIntArray(String s) {
        int [] sArray = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            sArray[i] = (int) s.charAt(i);
        }
        Arrays.sort(sArray);
        return sArray;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        } else {
            int[] tA = convertToSortedIntArray(t);
            int[] sA = convertToSortedIntArray(s);
            for (int i = 0; i < tA.length; i++) {
                if (tA[i] != sA[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
