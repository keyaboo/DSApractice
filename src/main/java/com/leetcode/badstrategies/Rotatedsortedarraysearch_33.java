package com.leetcode.badstrategies;

public class Rotatedsortedarraysearch_33 {

    /**
     * determine whether target and midpoint are on the same side or not by comparing against the first value in the
     * array
     * if they are, create a long num equal to nums[midpoint] to use for regular binary search comparison
     * if they're not, assign it to be either the largest or smallest possible long value
     * proceed with regular BS except replacing what would normally be num[midpoint] with the newly created long
     * @param nums
     * @param target
     * @return
     */
    public int searchUnusual(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int midPoint = start + ((end - start) / 2);
            boolean sameSide = (nums[midPoint] < nums[0]) == (target < nums[0]);
            long num = (sameSide) ? nums[midPoint] : (target < nums[0]) ? Long.MIN_VALUE : Long.MAX_VALUE;
            if (num < target) {
                start = midPoint + 1;
            } else if (num > target) {
                end = midPoint;
            } else {
                return midPoint;
            }
        }
        return -1;
    }
}
