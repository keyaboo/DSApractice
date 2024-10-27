package com.leetcode.accepted;

import java.util.Random;

/*
if the array is already sorted you will get absolutely dreadful performance.
^ No it wasn't that. The max heap solution which is way easier is also much faster.
O(n^2) is easy to imagine for worst case because it's possible we choose a very large k,
perhaps we started with a sorted array and always picked the rightmost term for pivot.
That means you'd be doing full scans of the array every single time and only decrementing
the size of that array by 1 for n times. Not pretty.
 */
public class KthLargestElementinArray_215 {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        Random rand = new Random();
        while (true) {
            int pivotIdx = left + rand.nextInt(right - left + 1);
            int res = partition(nums, left, right, pivotIdx);
            if (res == nums.length - k) {
                return nums[res]; // don't return res because there's sorting going on and you will have nonsense.
            } else if (res > nums.length - k) {
                right = res - 1;
            } else if (res < nums.length - k) {
                left = res + 1;
            }
        }
    }

    public int partition(int[] arr, int left, int right, int pivotIdx) {
        int pivot = arr[pivotIdx];
        swap(arr, right, pivotIdx);
        int climber = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, climber);
                climber++;
            }
        }
        swap(arr, climber, right);
        return climber;
    }



    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
