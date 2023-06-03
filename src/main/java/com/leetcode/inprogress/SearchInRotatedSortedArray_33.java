package com.leetcode.inprogress;


/**
 * binary search skeleton for non rotated array.
 */
public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        if (nums[0] < nums.length - 1) {
            while (start < end) {
                int midPoint = start + (end - start) / 2;
                if (target > midPoint) {
                    start = midPoint;
                } else if (target < midPoint) {
                    end = midPoint;
                }
            }
            return (nums[start] == target) ? start : -1;
        }
        return -1;
    }
}
