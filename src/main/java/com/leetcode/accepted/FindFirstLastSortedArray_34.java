package com.leetcode.accepted;

/*
ERRICHTO!!!
 */
public class FindFirstLastSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] == target) break; // guaranteed to be first position
            int mid = left + ((right - left) / 2);
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) { // this is the only one that actually matters.
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            int last = left;
            while (last < (nums.length - 1)  && nums[last + 1] == target) {
                last++;
            }
            return new int[] {left, last};
        } else {
            return new int[] {-1, -1};
        }
    }
}
