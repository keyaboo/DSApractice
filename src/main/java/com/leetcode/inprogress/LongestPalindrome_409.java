package com.leetcode.inprogress;

/**
 * hashmap where case-sensitive char is key, value is the frequency of character appearing in the input string
 * the temptation is to just sort since you would find out earlier if a center character appears or not but
 * that kicks up time complex to O(nlogn). I guess better to have a hashset of the characters accounted for
 * so you never re-check when you loop over a second time. do a modulo 2 == 1 check on all the values for the
 * central unpaired flag, and just count up the int (2) division of the values to start building your answer.
 *
 */
public class LongestPalindrome_409 {
}
