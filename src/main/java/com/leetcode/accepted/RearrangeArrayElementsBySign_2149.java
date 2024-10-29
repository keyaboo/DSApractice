package com.leetcode.accepted;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
variation on the two-pointer strategy.
 */
public class RearrangeArrayElementsBySign_2149 {
    public int[] rearrangeArrayBad(int[] nums) {
        int n = nums.length;
        int[] positives = new int[n/2];
        int[] negatives = new int[n/2];
        int posIdx = 0;
        int negIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positives[posIdx++] = nums[i];
            } else {
                negatives[negIdx++] = nums[i];
            }
        }
        int[] res = new int[n];
        posIdx = 0;
        negIdx = 0;
        for (int i = 0; i < n - 1; i = i + 2) {
            res[i] = positives[posIdx++];
            res[i+1] = negatives[negIdx++];
        }
        return res;
    }

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int posIdx = 0;
        int negIdx = 1;
        for (int i = 0; i < nums.length; i++) {
            // boolean even = i % 2 == 0;
            if (nums[i] > 0) {
                res[posIdx] = nums[i];
                posIdx = posIdx + 2;
            } else {
                res[negIdx] = nums[i];
                negIdx = negIdx + 2;
            }
        }
        return res;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
