package com.leetcode.inprogress;

/**
 * binary search skeleton for non rotated array.
 *
 * the way things end up working is that the only thing that matters is whether the midpoint is greater than start
 * or less than start. oh I get an error on testcase 130 nice
 *
 * 7 8 9 1 2 3 4
 * | t r?   M     | m < s, s < t, e < t => end = m-1
 * |   r? t M     | m < s, s > t, e > t => end = m-1
 * |       M t r? | m > s, s < t, e < t => start = m + 1
 * |       M  r? t| m > s, s > t, e > t => start = m + 1
 */
public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
            while (start <= end) {
                int midPoint = start + (end - start) / 2;
                if (nums[midPoint] == target) {
                    return midPoint;
                }
                if (nums[start] > nums[end]) {
                    if (nums[midPoint] < nums[start]) {
                        if (nums[start] < target && nums[end] > target) {
                            end = midPoint - 1;
                        } else {
                            end = midPoint - 1;
                        }
                    } else {
                        if (nums[start] < target && nums[end] < target) {
                            start = midPoint + 1;
                        } else {
                            start  = midPoint + 1;
                        }
                    }
                }
                else if (target > midPoint) {
                    start = midPoint + 1;
                } else {
                    end = midPoint - 1;
                }
            }

        return -1;
    }
}
