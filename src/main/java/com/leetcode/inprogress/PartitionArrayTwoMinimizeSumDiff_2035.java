package com.leetcode.inprogress;

import java.util.Arrays;

/*
2 arrays of possibly equal size or possibly right bigger than left filled with arbitrary numbers with the objective
of getting both to add up as close to target as possible.
n = 4 would have to swap 0, 2 and 0, 3 move onto 1,2 and 1,3. Since this is only finding the number I suppose
you don't actually need to swap. need a version of left/right sum that doesn't change so can refer back to it.
have for loop over left, nested for loop over right. dp array of what exactly though?
 */
public class PartitionArrayTwoMinimizeSumDiff_2035 {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int sum = 0;
        for (int num : nums) sum+= num;
        int target = sum / 2;
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < mid; i++) {left[i] = nums[i]; leftSum += nums[i]; }
        for (int j = mid+1, rightIndex = 0; j < n; j++) {right[rightIndex++] = nums[j]; rightSum += nums[j];}
        int minDifference = Math.abs(leftSum - rightSum);
        for (int i = 0; i < mid; i++) {

        }
        return minDifference;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];

    }
}
