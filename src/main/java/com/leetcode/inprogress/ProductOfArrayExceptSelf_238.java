package com.leetcode.inprogress;

public class ProductOfArrayExceptSelf_238 {
    /*
    I think you keep track of what
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[n];
        suffix[n-1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = nums[i+1] * suffix[i+1];
        }
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i-1] * prefix[i-1];
        }
        int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            res[i] = suffix[i] * prefix[i];
        }
        return res;
    }
}
