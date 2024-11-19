package com.leetcode.badstrategies;

import java.util.Arrays;

/*
You could have a last seen array like maximum swap of size 10. if lastSeen[num[i] > (i - k) then you don't do the
max calculation with the current sum. have a queue of size k that decrements the sum.
Ok looked at the editorial and they do like to move the window in from the left, I don't see why that's necessary
but it's a little prettier. I had sum inside the if statement which is stupid, sum increments no matter what.

The numbers aren't 0 - 9 this is so annoying.
 */
public class MaximumSumDistinctSubarrayLengthK_2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0L;
        long max = 0L;
        int left = 0;
        int right = 0;
        int[] lastSeen = new int[10];
        Arrays.fill(lastSeen, -1);
        while (right < nums.length) {
            int num = nums[right];
            int seenLast = lastSeen[num];

            while (((right - left + 1) > k) || seenLast >= left) {
                sum -= nums[left++];
            }
            lastSeen[num] = right;
            sum += num;

            if ((right - left + 1) == k) {
                max = Math.max(max, sum);
            }

            right++;
        }
        return max;
    }
}
