package com.leetcode.accepted;

import java.util.HashMap;
import java.util.Stack;

/*
    daily 10/10/2024
    Create a monotonic stack for the purpose of storing the indices where nums[i] is less than nums[TOS].
    Then do a second pass going in reverse, call counter for it j.
    Check to see whether nums[j] is >= nums[TOS], and if so pop it and do a ramp reassignment. However,
    if the stack isn't empty, there's going to be an even wider ramp for the next value on the stack.
    So this check needs to be done in a while loop until either the stack is empty or the nums[j] <= nums[TOS]
    a large nums[0] could still be at the bottom of stack and hold up knowing the answer.

    alternative 2P (practice some day):
    create an array of max values to the right eg nums: [1,6,5,2,4] -> [6,6,5,4,4]
    counter right is used to progress along second array for every loop iter, terminating at end of array.
    only move left if it's gt maxright[right], left can't exceed right. maxramp candidate is
    itself or right - left.
 */
public class MaximumWidthRamp_962 {
    public int maxWidthRamp(int[] nums) {
        int ramp = 0;
        Stack<Integer> monoDecrease = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (monoDecrease.isEmpty() || nums[i] < nums[monoDecrease.peek()])
                monoDecrease.add(i);
        }
        // insisting that j >= ramp is just a little faster than checking the whole array and insisting j >= 0
        for (int j = nums.length - 1; j >= ramp; j--) {
            while (!monoDecrease.isEmpty() && (nums[j] >= nums[monoDecrease.peek()])) {
                ramp = Math.max(ramp, j - monoDecrease.pop());
            }
        }
        return ramp;
    }
}
