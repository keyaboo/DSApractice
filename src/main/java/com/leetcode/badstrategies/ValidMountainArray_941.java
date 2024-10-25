package com.leetcode.badstrategies;

public class ValidMountainArray_941 {


/*
redo this trash
 */
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        boolean pivot = false;
        for (int i = 1; i < arr.length - 1; i++) {
            if (!pivot) {
                if ((arr[i-1] < arr[i]) && (arr[i] < arr[i+1])) {
                    continue;
                } else if (arr[i-1] < arr[i] && arr[i] > arr[i-1]) {
                    pivot = true;
                } else {
                    return false;
                }
            } else {
                if (arr[i+1] >= arr[i]) { return false; }
            }
        }
        return pivot;
    }
}
