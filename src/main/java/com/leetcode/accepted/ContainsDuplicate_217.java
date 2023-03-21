package com.leetcode.accepted;

import java.util.HashSet;
import java.util.Set;

/**
 * very obvious hashset problem, doing this bc Greg decided to. I guess I reached the point
 * where some of the easy problems are as trivial as they should be?
 */
public class ContainsDuplicate_217 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (uniqueSet.contains(nums[i])) {
                return true;
            } else {
                uniqueSet.add(nums[i]);
            }
        }
        return false;
    }
}
