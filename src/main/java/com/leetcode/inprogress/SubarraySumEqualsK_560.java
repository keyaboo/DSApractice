package com.leetcode.inprogress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
I had the prefix sum approach right with the map but I was storing the indices with a list rather than the frequencies.

 */
public class SubarraySumEqualsK_560 {
    public int subarraySumBF(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int total = k - nums[i];
            if (total > 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    total -= nums[j];
                    if (total == 0) {count++; }
                    break;
                }
            }
        }
        return 0;
    }


    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freqByPrefixSum = new HashMap<>();
        int count = 0;
        int sum = 0;
        freqByPrefixSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (freqByPrefixSum.containsKey(sum-k)) {
                count = count + freqByPrefixSum.get(sum-k);
            }
            freqByPrefixSum.put(sum, freqByPrefixSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /*
    getOrDefault is a fancy way of doing this basically
    if (preSum.containsKey(sum)) {
        preSum.put(sum, preSum.get(sum) + 1);
    } else {
        preSum.put(sum, 1);
    }
     */
}
