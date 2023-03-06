package com.leetcode.accepted;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * very easy two pointer problem
 */
public class NumDistinctAverages_2465 {
    public static void main(String[] args) {
        int[] nums = {4,1,4,0,3,5};
        System.out.println(distinctAverages(nums));
    }

    public static int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Float> avgs = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < ((len)/2); i++) {
            int head = i;
            int tail = len - 1 - i;
            float avg = ( (float) nums[head] + (float) nums[tail] ) / 2;
            avgs.add(avg);
        }
        return avgs.size();
    }

}
