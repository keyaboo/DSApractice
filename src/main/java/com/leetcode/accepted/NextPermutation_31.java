package com.leetcode.accepted;

/*
error: compare the values* at successor and pivot. have to add the breaks when you find successor and pivot.

Commentary on the final reversal: If there's no pivot found in the NP algorithm, the entire array is in descending
order and it is already the largest permutation possible with the given elements. If you imagine the array
[1, 3, 5, 4, 2] having a corresponding cmp array [1, 1, -1 -1], we find the rightmost 1, and everything after that
should be strictly descending or -1.

illustrative example is: [2, 5, 4, 3, 1]
the pivot is 2 idx 0, the successor is 3 idx 3. cmp array : [1, -1, -1, -1]
and when you find the next permutation array is [3, 1, 2, 4, 5] which has a cmp array: [-1, 1, 1, 1]
 */
public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] < nums[i+1]) {
                pivot = i;
                break;
            }
        }
        if (pivot >= 0) {
            int successor = -1;
            for (int i = nums.length - 1; i > pivot; --i) {
                if (nums[i] > nums[pivot]) {
                    successor = i;
                    break;
                }
            }
            swap(nums, successor, pivot);
            reverse(nums, pivot+1, nums.length-1);
        } else {
            reverse(nums,0, nums.length-1);
        }
    }


    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

}
