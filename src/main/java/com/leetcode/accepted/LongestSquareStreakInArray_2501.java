package com.leetcode.accepted;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    there are a LOT of silly little things about this problem that the map doesn't have to worry about. O(n) which
    is nice but first line I'd have some trouble remembering.
 */
public class LongestSquareStreakInArray_2501 {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> allNums = new HashSet<>(Arrays.asList((Arrays.stream(nums).boxed().toArray(Integer[]::new))));
        int longestStreak = 0;
        for (int i = 0; i < nums.length; i++) {
            long curr = nums[i];
            int count = 0;
            while (allNums.contains(((int) curr))) {
                count++;
                if (curr * curr > 1e5) break; // failed a late test case bc of this.
                curr = curr * curr;
            }
            longestStreak = Math.max(longestStreak, count);
        }
        return (longestStreak < 2) ? -1 : longestStreak;
    }
}
