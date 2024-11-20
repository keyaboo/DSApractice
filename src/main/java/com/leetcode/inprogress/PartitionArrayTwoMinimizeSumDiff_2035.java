package com.leetcode.inprogress;

import java.util.Arrays;

/*
2 arrays of possibly equal size or possibly right bigger than left filled with arbitrary numbers with the objective
of getting both to add up as close to target as possible. Very easy to imagine this as an n! kind of problem.
Even number of integers for nums that makes things easier, I wasn't sure whether to make target (n/2) or (n/2) + 1
depending on whether sum was odd or even but probably safe to make it (n/2).

 */
public class PartitionArrayTwoMinimizeSumDiff_2035 {
    public int minimumDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length / 2;
        return 0;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
