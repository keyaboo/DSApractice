package com.leetcode.accepted;

/**
 * not too bad.
 */
public class BinarySearch_704 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, 9));
    }

    public static int search(int[] nums, int target) {
        int endpoint = nums.length - 1;
        int startpoint = 0;
        return binarySearch(nums, target, startpoint, endpoint);
    }

    public static int binarySearch(int[] nums, int target, int start, int end) {
        int midpoint = start + ((end - start) / 2);
        if (nums[midpoint] == target) {
            return midpoint;
        } else if (target < nums[start] || target > nums[end]) {
            return -1;
        } else if (midpoint == start) { // accounting for the delta between start/end being 1 index unit
            if (nums[end] == target) {
                return end;
            } else {
                return -1;
            }
        }
        if (nums[midpoint] > target) {
            midpoint = binarySearch(nums, target, start, midpoint);
        } else if (nums[midpoint] < target) {
            midpoint = binarySearch(nums, target, midpoint, end);
        }
        return midpoint;
       }

}
