package com.leetcode.guided.set1;

public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                pivot = i;
                break;
            }
        }
        if (pivot >= 0) {
            int successor = -1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[pivot]) {
                    successor = i;
                    break;
                }
            }
            swap(nums, pivot, successor);
            reverse(nums, pivot+1, nums.length -1);
        } else {
            reverse(nums, 0, nums.length-1);
        }
    }


    public void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
