package com.leetcode.inprogress;

import java.util.Stack;

/**
 * gonna use a stack on this one
 * the best solution appears to start from 1 and count up. imo this divide & conquer is a lot easier to understand
 * the way to do it starting from the bottom:
 * start with 1 as an updating 'curr' variable, check if it's equal to the array at index (which starts at 0),
 * if not, keep track of it with a counter variable and do curr++, but if it is, go to next index of array and curr++
 */
public class KthMissingNumber_1539 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        int solution = findKthPositive(arr,k);
        System.out.println(solution);
    }

    public static int findKthPositive(int[] arr, int k) {
        Stack<Integer> vals = new Stack<>();
        int highestInArray = arr[arr.length - 1];
        int highestPossible = arr[arr.length - 1] + k;
        pushMissingOntoStack(highestPossible + 1, highestInArray, vals);

//        System.out.println(vals.pop());
        for (int i = arr.length - 1; i > 0; i--) {
            pushMissingOntoStack(arr[i], arr[i-1], vals);
        }
        pushMissingOntoStack(arr[0],0, vals);
        for (int i = 0; i < k-1; i++) {
            vals.pop();
        }
        return vals.peek();
    }

    public static void pushMissingOntoStack(int high, int low, Stack<Integer> stack) {
        for (int i = high; (i - low) > 1; i--) {
            stack.push(i-1);
        }
    }
}
