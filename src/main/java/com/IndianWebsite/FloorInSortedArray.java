package com.IndianWebsite;

public class FloorInSortedArray {
    /*
    complete the loop of the search just like search insert position problem. Can from the beginning return the -1
    if target is below arr[0]. For this problem the usual shift of left and right needs another check because you
    could have your answer in mid already in which case you want to not proceed with another loop iteration.
    What keeps the accessing of mid + 1 from being sketchy is the left < right assertion, meaning mid will never
    be the last index and safeguarding out-of-bounds access.
     */
    public static int findFloor(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        if (arr[left] > k) return -1;
        while (left < right) {
            int mid = left + ((right - left) / 2);
            if (arr[mid] == k || (arr[mid] < k && arr[mid+1] > k)) return mid;
            else if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    /*
    "Ceil The Floor" ok
    this runs O(n) so just a greedy reassignment.
     */

    public int[] getFloorAndCeil(int x, int[] arr) {
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num <= x) {
                floor = Math.max(floor, num);
            }
            if (num >= x) {
                ceil = Math.min(ceil, num);
            }
        }
        floor = (floor == Integer.MIN_VALUE) ? -1 : floor;
        ceil = (ceil == Integer.MAX_VALUE) ? -1 : ceil;
        return new int[] {floor, ceil};
    }
}
