package com.leetcode.inprogress;

public class ProductOfArrayExceptSelf_238 {
    /*
    prefix and suffix approach is straightforward.
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

    /*
    having res itself start out as the prefix array is problem-specific kind of thing.
    Have a greedy variable to handle suffix products.
     */

    public int[] productExceptSelfConstantSpace(int[] nums) {
        int n = nums.length; // often nice to declare but for this problem it's peace of mind in the for loops
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1]; // basic prefix product array
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) { // from the back of both, res starts out huge.
            res[i] *= right; // ok just have a greedy variable do the same thing.
            right *= nums[i];
        }
        return res;
    }
}
