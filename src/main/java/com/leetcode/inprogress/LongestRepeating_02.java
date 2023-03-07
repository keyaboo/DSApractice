package com.leetcode.inprogress;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * s consists of english letters, digits, symbols, and spaces
 */
public class LongestRepeating_02 {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthofLongestSubstring(s));

    }

    public static int lengthofLongestSubstring(String s) {
        // edge case of ""
        int longesetLength = 0;
        if (s.length() == 0) {
            return 0;
        } else {
            for (int i = 0; i < s.length(); i++) {
                System.out.println(s.charAt(i));
                Set<Character> contained = new HashSet<>();
                int length = 0;
                int k = 0; // going right starting with the character at the index of i
                while (i + k < s.length()) {
                    if (!(contained.contains(s.charAt(i+k)))) {
                        contained.add(s.charAt(i + k));
                        length++;
                    } else {
                        if (length > longesetLength) {
                            longesetLength = length;
                        }
                        break;
                    }
                   k++;
                }
            }
            return longesetLength;
        }
    }

    /**
     * this was the utter garbage that I had come up with once upon a time
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringOld(String s) {

        Integer longest = (s.length() > 0) ? 1 : 0;

        for (int i = 0; i < s.length(); i++) {
            Integer templength = 1;
            char c = s.charAt(i);
            int j = 1;
            int k = 1;
            ArrayList<Character> arr = new ArrayList<Character>();
            arr.add(c);
            boolean stay = true;
            while ((!(i - j <= 0) || !(i + k >= s.length())) && stay) {
                Character d = !(i - j <= 0) ? s.charAt(i - j) : null;
                Character e = !(i + k >= s.length()) ? s.charAt(i + k) : null;

                if (d == null && arr.contains(e) || e==null && arr.contains(d)) { stay = false;}

                if (d != null && (!arr.contains(d))) { arr.add(d); templength++; System.out.println("backwards addn");}
                if (e != null && (!arr.contains(e))) { arr.add(e); templength++; System.out.println("forwards addn");}
                k++;
                j++;
                longest = (templength > longest) ? templength : longest;

            }
        }
        System.out.println(longest);
        return longest;

    }

}
