package com.leetcode.badstrategies;

/**
 * this seems like a sliding window problem. check if the inclusion of the element to the right keeps the running
 * sum > 0, if so keep going. running sum is the greedy variable.
 *
 * time lmit exceeded for an outrageously large array full of positive values. O(n) solution possible according
 * to the description and this is more brute force than that. Into the trash this goes.
 */
public class MaximumSubarray_53 {
    public static void main(String[] args) {
        int[] nums = {-1};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int left = 0;
        int right = 0;
        int maxSum = nums[0]; // i set this to 0 beforehand but the bs [-1] edge case meant I couldn't do that.
        while (left < nums.length) {
            int currentSum = nums[left];
            right = left + 1;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (left == nums.length - 1 && currentSum >= maxSum) {
                return currentSum;
            }
                while (right < nums.length) {
                    if (currentSum + nums[right] > 0) {
                        currentSum = currentSum + nums[right];
                        if (currentSum > maxSum) {
                            maxSum = currentSum;
                        }
                    right++;
                    } else {
                        break;
                    }
                }
            left++;
        }
        return maxSum;
    }


}
