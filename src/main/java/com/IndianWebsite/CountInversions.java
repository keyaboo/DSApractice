package com.IndianWebsite;

/*
Ok all the things that got messed up with the reattempt merge sort.
- didn't set right equal to arr.length - 1
- didn't write base case as the first line in the subarray function
- didn't need a search index because a more natural way to count up the 'inversions' is embedded in the mergesort
big while loop that compares the different split arrays. But the thing to notice is that, since those two are
sorted, you can count ALL numbers between mid and left index.

The reverse pairs loop is designed to count the pairs (i, j) such that i < j and nums[i] > 2 * nums[j]

in my own words, RP, the first loop is attempting to count up all the values in the right subarray that are
greater than or equal to left[index]. In regular merge sort and in this inversion count subarray, the variable
of interest is not defined by the left subarray (the way count += mid - leftIndex + 1 is here) but by the right
subarray. The further left we go, the less likely the condition for incrementing variable of interest becomes, so
we have to slow things down and do leftIndex checks one at a time.
 */
public class CountInversions {
    static int inversionCount(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        return inversionCountSubArray(arr, left, right);
    }

    private static int inversionCountSubArray(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = inversionCountSubArray(nums, left, mid) + inversionCountSubArray(nums, mid+1, right);
        int searchIndex = mid + 1;
        int leftIndex = left;
        int rightIndex = mid + 1;
        int[] merged = new int[right - left + 1];
        int mergeIndex = 0; // problem
        while (leftIndex <= mid && rightIndex <= right) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                merged[mergeIndex++] = nums[leftIndex++];
            } else {
                merged[mergeIndex++] = nums[rightIndex++];
                count += mid - leftIndex + 1;
            }
        }

        while (leftIndex <= mid) {
            merged[mergeIndex++] = nums[leftIndex++];
        }

        while (rightIndex <= right) {
            merged[mergeIndex++] = nums[rightIndex++];
        }

        System.arraycopy(merged, 0, nums, left, merged.length);
        return count;
    }


}
