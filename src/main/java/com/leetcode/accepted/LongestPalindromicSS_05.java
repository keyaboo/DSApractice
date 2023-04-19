package com.leetcode.accepted;

/**
 * The temptation here is to cheat with the arrayDequeue that can push characters onto
 * both the beginning and end, but that's a little too java specific so just go with
 * sliding window approach, have a greedy Stringbuilder -> string that gets updated
 * whenever a longer palindrome is found.
 *
 * I'm a dumbass, strings are immutable
 * ^ not the problem, what did pop up here was:
 * substring end is non-inclusive, so the way I have devised this you want to grab right+1
 *
 * failed on "ccc", shoot me
 *
 * right pointer should be adjacent same character except when you don't want to do that.
 *
 * set up the bounds appropriately to consider all possible bullshit.
 *
 * then it fails on "bb"
 *
 * fails on "aaaa"
 *
 * ok lesson here, don't set up bounds for duplicates, use while loops to keep left/right
 * moving if left-1/right+1 is the same character as what's on index i. besides that be sure
 * to account for substring end's non-inclusivity.
 */
public class LongestPalindromicSS_05 {

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            // was previously so ugly breaking on all sorts of BS.
            int right = i;

            char c = s.charAt(i);

            while (right < s.length() - 1 && s.charAt(right + 1) == c) {
                right++;
            }

            while (left > 0 && s.charAt(left - 1) == c) {
                left--;
            }
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    int currentLength = right - left;
                    if (currentLength >= longest.length()) {
                        longest = s.substring(left, right + 1);
                    }
                    right++;
                    left--;
                } else {
                    break;
                }

            }

        }
        return longest;
    }
}
