package com.leetcode.accepted;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * this one I feel ought to have an elegant one pass solution since majority should be more straightforward
 * than map<num, freq> and then cycling through the keys checking for values >= n/2, the follow-up all but
 * confirms there's a O(1) space greedy way of doing so.
 *
 * update:
 * wouldn't you know it, there totally was a better approach that wouldn't have been obvious like the hashing soln.
 *
 * https://www.cs.utexas.edu/~moore/best-ideas/mjrty/
 *
 * summary of the one pass, hold onto a single value that you count as your "majority", which gets a starting count
 * of 1 if it's the first thing being looked at, decrement the count if subsequent values are not the same value,
 * if current count is reset to 0 then the next value being looked at is treated like the first value of the array,
 * it becomes the greedy "majority" with count = 1. Since the problem has already provided that a majority does
 * exist for the supplied array, by the time you reach the end no matter what the greedy majority variable will
 * necessarily be what you return.
 */
public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        HashMap <Integer, Integer> map = new HashMap<>();
        Set<Integer> keys = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            keys.add(nums[i]);
            if (map.containsKey(nums[i])) {
                int newTotal = map.get(nums[i]) + 1;
                map.put(nums[i], newTotal);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer key:keys) {
            if (map.get(key) >= ((nums.length / 2)) + 1) {
                return key;
            }
        }
        return 0;
    }

    /**
     * the approach from that univ texas site.
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int greedyMajority = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                greedyMajority = nums[i];
                count++;
            } else if (nums[i] == greedyMajority) {
                count++;
            } else {
                count--;
            }
        }
        return greedyMajority;

    }

}
