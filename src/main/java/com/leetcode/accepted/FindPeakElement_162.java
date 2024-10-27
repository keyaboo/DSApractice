package com.leetcode.accepted;

public class FindPeakElement_162 {
    /*
    Don't mess with checking left and right. This is binary search with the criteria for movement being the relative
    incline of mid's adjacent terms rather than
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[0] > nums[1]) { return 0; }
        if (nums[right] > nums[right-1]) { return right; }
        while (left < right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            else if (nums[mid] > nums[mid+1]) { left = mid+1; }
            else if (nums[mid] > nums[mid-1]) { right = mid-1; }
        }
        return 0;
    }
}
