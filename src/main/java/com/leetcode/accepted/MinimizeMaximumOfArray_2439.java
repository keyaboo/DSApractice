package com.leetcode.accepted;

/**
 * one of those how would anyone be expected to know that sort of problems. The only operation described by the
 * problem can only move values leftward, so rather than actually doing it, know that the max has to eventually
 * appear in the first position, and keep a running average of what that number would inevitably look like. No
 * monotonic stacks, no recursion or any of the other dumb stuff I tried.
 */
public class MinimizeMaximumOfArray_2439 {
    public static void main(String[] args) {
        int[] nums = {3,7,1,6};
        System.out.println(minimizeArrayValue(nums));
    }

    public static int minimizeArrayValue(int[] nums) {
        int smallestMaximum = 0;
        double currentSum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum + nums[i];
            double runningAvg = currentSum / (i + 1.0);
            if (Math.ceil(runningAvg) > smallestMaximum) {
                smallestMaximum = (int) Math.ceil(runningAvg);
            }
        }
        return smallestMaximum;
    }
}
