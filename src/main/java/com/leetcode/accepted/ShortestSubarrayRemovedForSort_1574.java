package com.leetcode.accepted;

import java.util.Stack;

/*
monotonic stack seems like. no, can have a very small value appear and reset stack
You search for pivots coming from both the left and the right.
You have to do long range comparisons pretty much to attempt to shrink the size of window.
 */
public class ShortestSubarrayRemovedForSort_1574 {

    // there are probably some problems with this so need to refine what I'm saying.
    // the width of the window closing in is j - i - 1 regardless of where you fix i and j to. I thought to
    // shift them to the right i be left, j be n-1 but incrementing is so much more straightforward.
    // i will go as far as its first pivot if it's below what j is looking at. right is the first pivot going
    //
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while ((left < (n - 1)) && arr[left] <= arr[left+1]) left++;
        while ((right > 0) && arr[right] >= arr[right - 1]) right--;
        if (left == n-1) return 0;
        int span = Math.min(right, n-1-left);
        int i = 0;
        int j = right;
        while (j < n && i <= left) {
            if (arr[i] <= arr[j]) {
                span = Math.min(span, j - i - 1);
                i++; // increment AFTER lol
            } else {
                j++;
            }
        }
        return span;
    }

    private class WrongSolution {
        public int findLengthOfShortestSubarray(int[] arr) {
            int n = arr.length;
            int removalCount = 0;
            Stack<Integer> monoIncrease = new Stack<>();
            monoIncrease.push(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                int num = arr[i];
                while (!monoIncrease.isEmpty() && num < monoIncrease.peek()) {
                    removalCount++;
                    monoIncrease.pop();
                }
                monoIncrease.push(num);
            }
            return removalCount;
        }
    }
}
