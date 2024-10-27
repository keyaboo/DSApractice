package com.leetcode.badstrategies;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
Sort
 */
public class JumpGameII_45 {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(new int[] {n-1, 0});
        visited.add(n-1);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currJumps = curr[1];
            int currIdx = curr[0];
            for (int i=currIdx; i >=0; --i) {
                if (i + nums[i] >= currIdx && !visited.contains(i)) {
                    if (i == 0) {
                        return currJumps + 1;
                    }
                    queue.add(new int[] {i, currJumps + 1});
                    visited.add(i);
                }
            }
        }
        return -1;
    }
}
