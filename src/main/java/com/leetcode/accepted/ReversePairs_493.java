package com.leetcode.accepted;

import java.util.Stack;

/*
    Overwriting the subarray region with array copy is fine in this context because the reverse pair calculation
    occurs first, the count is incremented before the arraycopy overwrite of nums range with the merged array.
    Nums after this is in sorted order.

    // Initial array: [5, 2, 8, 1, 9]

    gets divided into smallest subarrays [5], [2], [8], [1], [9]

    count reverse pairs condition (+1) over the subproblem [5, 2], and overwrite the original array:
    [2, 5, 8, 1, 9]

    another subproblem: [8, 1] rp condition is again +1. merged = [1, 8]
    [2, 5, 1, 8, 9]

    another subproblem, ([2,5] and [1,8]), finds hit for the rp condition +1, overwrite:
    [1,2,5,8] 5 shows up first with star, 8 is fill up with smile.

    another subproblem [1, 2, 5, 8] and [9], which finds no reverse pairs.
    final nums: [1, 2, 5, 8, 9]

    even though the rpSA function cares about the relative sizes of subarrays being compared, for inductive
    demonstration of the merging it's fine to pretend a base case is just another unit or whatever.
 */
public class ReversePairs_493 {
    public int reversePairs(int[] nums) {
        return reversePairsSubarray(nums, 0, nums.length - 1);
    }

    private int reversePairsSubarray(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + ((right - left) / 2);
        int count = reversePairsSubarray(nums, left, mid) + reversePairsSubarray(nums, mid + 1, right);

        int leftIndex = left;
        int rightIndex = mid + 1;
        int mergeIndex = 0;
        int searchIndex = mid + 1;

        int[] merged = new int[right - left + 1];

        while (leftIndex <= mid) {
            while (searchIndex <= right && nums[leftIndex] > 2L * nums[searchIndex]) {
                searchIndex++;
            }
            count += searchIndex - (mid + 1);
            // I have no idea why you have to do this rather than having count++ in the above loop.
            // edit: I know why: as you move to the next leftIndex in the outer loop, the value of nums[leftIndex]
            // will either stay the same or increase since the left subarray is already sorted. The previous
            // steps searchIndex is still valid or needs to move even further to the right to find the first
            // non-reverse pair element.

            while (rightIndex <= right && nums[leftIndex] >= nums[rightIndex]) {
                merged[mergeIndex++] = nums[rightIndex++]; // preferentially fill merged with smaller values from the right SA
            }
            merged[mergeIndex++] = nums[leftIndex++]; // star
        }

        while (rightIndex <= right) {
            merged[mergeIndex++] = nums[rightIndex++]; // smile
        }

        System.arraycopy(merged, 0, nums, left, merged.length);
        return count;
    }
}
