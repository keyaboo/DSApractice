package com.leetcode.badstrategies;

import java.util.HashMap;

/**
 * reattempt and it like wasn't any better
 */
public class ValidAnagram_242_redoneworse {
    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character,Integer> sHashed = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sHashed.containsKey(s.charAt(i))) {
                sHashed.put(s.charAt(i),sHashed.get(s.charAt(i)) + 1);
            } else {
                sHashed.put(s.charAt(i),1);
            }
        }
        for (int k = 0; k < t.length(); k++) {
            if (sHashed.containsKey(t.charAt(k))) {
                sHashed.put(t.charAt(k), sHashed.get(t.charAt(k)) - 1);
                int count = sHashed.get(t.charAt(k));
                if (count < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
