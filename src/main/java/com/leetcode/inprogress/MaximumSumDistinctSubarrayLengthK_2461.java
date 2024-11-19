package com.leetcode.inprogress;

import java.util.HashMap;

/*
so this is overcounting. oh I wasn't adding an entry for num in the map. Also made a mistake about lastSeen being
greater than or equal to left so that's not good. lastSeen >= left is a duplicate detector, >= ensures that even if
the duplicates span the entire window (nums[left] == nums[right]), the duplicate is identified and you're not going
to consider the sum as a max possibility.
 */
public class MaximumSumDistinctSubarrayLengthK_2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0L;
        long max = 0L;
        HashMap<Integer, Integer> lastSeenIndexByNum = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            int num = nums[right];
            int lastSeen = lastSeenIndexByNum.getOrDefault(num, -1);
            while ((((right - left) + 1) > k) || (lastSeen >= left)) {
                sum -= nums[left++];
            }
            sum += num;
            lastSeenIndexByNum.put(num, right);
            if ((right - left + 1) == k) {
                max = Math.max(sum, max);
            }
            right++;
        }
        return max;
    }
}
