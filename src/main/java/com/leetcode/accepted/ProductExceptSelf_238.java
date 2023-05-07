package com.leetcode.accepted;

/**
 * O(n) time but we can use more space. could initialize an array as int[nums.length - 1] full of 1s.
 * nvm that would be O(nlogn) I think. Not sure you even care about what the final product here is.
 * ok took a glance at a solution. couldn't tell which side was important to start from, turns out they both are.
 *
 * left product comes from product of all rights.
 * secondmost left comes from the product of rights sweeping left and the cumulative product of the lefts.
 * right product comes from a greedy product variable right that holds onto current product coming from right.
 *
 * this is the trickier O(1) solution since it uses a greedy right variable instead of constructing two different
 * arrays for left/right.
 *
 * [1,2,3,4]
 * [placeholder 1, 1 * 1(PH) = 1, 2 * 1 = 2, 3 * 2 = 6]
 * [1, 1, 2, 6]
 *
 * from R -> L: [6 * 1 = 6 (R = 6), 2 * now where do we get 4 from? nums instead of res. nums[nums.length-1] * 2 = 4,
 * ]
 * [24, 12, 8, 6]
 */
public class ProductExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1] ;
        }
        int right = 1;
        // this is a bad, confusing loop but it's my bad, confusing loop.
        for (int i = res.length; i > 0; i--) {
            res[i - 1] = res[i-1] * right;
            right = right * nums[i - 1]; // this I changed from nums to right to back to nums again.
        }

        return res;
    }

    /**
     * now if we didn't care about O(1) space here, we could do two cycles.
     * did not cheat here. it's wrong nvm, need greedy L/R variables like the O(1) version had. I can correct.
     *
     * 1,2,3,4
     * LP: [1 PH * 1 = 1, 2 * 1 = 2
     * RP: 4 * 1 = 4
     *
     * [3, 2, 4]
     * L [3, ...] -> [3, 6, ...]
     * R [..., 4] -> [..., 8, 4]
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelfWorse(int[] nums) {
        int[] leftProducts = new int[nums.length];
        int[] rightProducts = new int[nums.length];
        int left = 1;
        int right = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1 - i;
            leftProducts[leftIndex] = nums[leftIndex - 1] * left;
            left = leftProducts[leftIndex];
            rightProducts[rightIndex] = nums[rightIndex] * right;
            right = rightProducts[rightIndex];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            if (i == 0) {
                res[i] = rightProducts[i + 1];
            } else if (i == res.length - 1) {
                res[i] = leftProducts[i - 1];
            } else {
                res[i] = leftProducts[i - 1] * rightProducts[i + 1];
            }
        }
        return res;
    }
}
