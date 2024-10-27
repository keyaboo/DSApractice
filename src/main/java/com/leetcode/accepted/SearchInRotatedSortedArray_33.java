package com.leetcode.accepted;

/*
    Binary search for the lowest term explanation. The core logic comes in comparing nums[mid] and nums[high].
    If the middle number is greater than the element at the end of the array, the smallest value must be on the
    right half of the array.

    For the second binary search, target may well be outside the current left and right bounds. But sorted order
    logic is maintained a la regular BS because the calculation of new mid has its mapping in the rotated array
    which you're provided with. left/right/mid operate in an unrotated array, midOught is the bridge between
    the search space and the corresponding position in the rotated array.
 */
public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = low + ((high - low)/2);
            if (nums[mid] > nums[high]) {
                low = mid +1;
            } else {
                high = mid;
            }
        }
        int pivot = low;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left)/2);
            int midOught = (mid + pivot)%n;
            if (nums[midOught] == target) {
                return midOught;
            }
            if (nums[midOught] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
