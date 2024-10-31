package com.leetcode.inprogress;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
This is basically the same problem as squares daily if you use the hashset approach. Oh I know why that dude in Larry's
discord looped through the hashset rather than the nums array. Ok you can do the array approach and go in both
directions or you can just ensure that what you're starting with doesn't have a lower sequence.
 */
public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> allNums = new HashSet<>(Arrays.asList((Arrays.stream(nums).boxed().toArray(Integer[]::new))));
        int longestStreak = 1;
        for (int num : allNums) {
            if (!allNums.contains(num - 1)) {
                int streak = 1;
                while (allNums.contains(num + 1)) {
                    num = num + 1;
                    streak++;
                }
                longestStreak = Math.max(longestStreak, streak);
            }
        }
        return longestStreak;
    }
}
