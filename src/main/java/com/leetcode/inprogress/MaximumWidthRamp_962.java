package com.leetcode.inprogress;

import java.util.HashMap;
import java.util.Stack;

/*
    daily 10/10/2024
    Create a monotonic stack for the purpose of storing the indices where nums[i] is less than nums[TOS].
    Then do a second pass going in reverse, call counter for it j.
    Check to see whether nums[j] is >= nums[TOS], and if so pop it and do a ramp reassignment. However,
    if the stack isn't empty, there's going to be an even wider ramp for the next value on the stack.
    So this check needs to be done in a while loop until either the stack is empty and the nums[j] <= nums[TOS]
    a large nums[0] could still be at the bottom of stack and hold up knowing the answer.
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
