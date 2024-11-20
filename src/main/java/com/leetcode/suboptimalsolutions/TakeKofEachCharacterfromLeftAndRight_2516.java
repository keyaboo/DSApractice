package com.leetcode.suboptimalsolutions;

public class TakeKofEachCharacterfromLeftAndRight_2516 {
    /*
    This seems like a recursive function with int return
    for minutes. function parameters could be the left and right pointer. I don't think you force the pickup in one
    direction or the other, 'main' is a Math.min of pickup at index left and right. But how to keep track of the
    counts that part is tricky.
    I looked at the hint and it gave me a solution for not having an obvious return for the left == right problem.
    The binary search loop doesn't have to factor in at all. I'm not progressing left and right with the solution.

    ok you don't want an integer return value, but their suggestion is to have a global variable for minutes.
    Oh this is O(2^n) shit.
     */
    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;
        int n = s.length();
        int[] counts = new int[3];
        int left = 0;
        int right = n - 1;
        int minutes = 0;
        int minMinutes = countMinutes(s, k, 0, s.length() - 1, counts, minutes);
        return (minMinutes == Integer.MAX_VALUE) ? -1 : minMinutes;
    }

    public int countMinutes(String s, int k, int left, int right, int[] counts, int minutes) {
        // int c = s.charAt(pickupIndex) - 'a';
        if (counts[0] >= k && counts[1] >= k && counts[2] >= k) {
            return minutes;
        }
        if (right < left) {
            return Integer.MAX_VALUE;
        }
        int[] leftCounts = counts.clone();
        leftCounts[s.charAt(left) - 'a']++;
        int leftCount = countMinutes(s, k,left+1, right, leftCounts, minutes+1);
        int[] rightCounts = counts.clone();
        rightCounts[s.charAt(right) - 'a']++;
        int rightCount = countMinutes(s, k, left, right-1, rightCounts, minutes+1);
        return Math.min(leftCount, rightCount);
    }
}
