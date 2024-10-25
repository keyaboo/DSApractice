package com.leetcode.redos;

public class MajorityElement_169 {
    /*
    I remembered this one and kept thinking that I needed to do some kind of sum but it isn't of the actual elements.
     */
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majority) {
                count++;
            } else if (nums[i] != majority) {
                count--;
                if (count == 0) {
                    majority = nums[i];
                    count = 1;
                }
            }
        }
        return majority;
    }
}
