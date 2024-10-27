package com.leetcode.accepted;

public class JumpGameII_45 {
    /*
    There's a reachability guarantee implying there will always be a vlaid jump from within the current range
    end to a farther index that eventually leads to the last index. My thought was whatever was furthest might
    be a 0 and therefore an invalid path, so I didn't immediately recognize this as a greedy problem.

    Similarities between this and buy/sell stock:
    maxProfit / jumps store the overall goal value, what gets returned.
    minPrice / farthest store information about the best position or state encountered so far.

     */
    public int jump(int[] nums) {
        int end = 0;
        int farthest = 0;
        int jumps = 0;
        for (int i = 0; i < nums.length; i++) {
            farthest = Math.max(i + nums[i], farthest);
            if (i == end) {
                jumps++;
                end = farthest;
                // end = i + nums[i]; this is what I originally had but it's wrong
                // it limits the jump range to only the index reachable from the current index (i, which happens to be end).
            }
        }
        return jumps;
    }
}
