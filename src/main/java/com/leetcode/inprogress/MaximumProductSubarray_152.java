package com.leetcode.inprogress;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
dp problem but doesn't look like one. max so far and min so far take turns talking to one another. Need to reset
both of these variables whenever you encounter a 0.
 */
public class MaximumProductSubarray_152 {
    public int maxProduct(int[] nums) {
        int maxSoFar = 1;
        int minSoFar = 1;
        int product = 0;
        int productMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxSoFar = 1;
                minSoFar = 1;
            } else if (nums[i] < 0) {
            } else if (nums[i] > 0) {
                maxSoFar = Math.max(nums[i], minSoFar*nums[i]);
                minSoFar = Math.min(nums[i], minSoFar*nums[i]);
            }
            productMax = Math.max(maxSoFar, productMax);
        }
        return productMax;
    }
}
