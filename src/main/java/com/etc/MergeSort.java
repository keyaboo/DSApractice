package com.etc;

public class MergeSort {

    /*
    T(i,j) is the "problem" applied to a subarray, here it's function mergeSort(arr, i, j) itself.
    Base case:
    when i >= j means the subarray has 0 or 1 elements and is already sorted.
    Recursive step:
    when i < j the steps for T(i, j) are to divide the middle index, recursively sort the left SA and right SA

    T(i, j) = T(i, m) + T(m + 1, j) + C where m = (i+j)/2, i.e., subarray nums[i, j] will be further partitioned
    into two parts and C denotes the subproblem for combining the two parts. We will call this partition recurrence relation.

     */
    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) { // BC for merge pairs is basically this except return a 0.
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            // merge pairs the recursive step is just add the returns of the splits together.
            merge(arr, left, right);
        }

    }

    public void merge(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        // merge pairs also creates these storage arrays

        for (int i = left; i < n1; i++) {
            arr1[i] = arr[i];
        }
        for (int j = 0; j < n2; j++) {
            arr2[j] = arr[j + mid];
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n1 && j < n2) { // one of these breaks first
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i++];
            } else {
                arr[k] = arr2[j++];
            }
            k++;
        }
        // after left or right array is fully copied, remaining elements in the other array are already sorted, and
        // larger than all the elements in the k/original array you have, so copying leftover elements does not
        // disturb the sorting like I thought it would.
        while (i < n1) {
            arr[k++] = arr1[i++];
        }
        while (j < n2) {
            arr[k++] = arr2[j++];
        }
    }

}
