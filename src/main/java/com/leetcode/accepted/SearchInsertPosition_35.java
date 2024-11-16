package com.leetcode.accepted;

public class SearchInsertPosition_35 {
    /*
    I thought ok maybe initialize mid before the loop and when l/m/r are all the same that's what I can use
    to find the index but nah don't try and initialize loop variables outside of them. Left is just the
    easiest to think about, and it's easier to think through why you'd never return left - 1 since that'd
    be outside of the array index bounds.
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] < target) return left + 1;
        else return left;
    }
}
