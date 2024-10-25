package com.leetcode.accepted;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
    I thought to start with a very wide range and have some sort of tagging system for the k
    lists. You'd make a min heap based on elements from each of the k lists, with a list
    identifier and current index. Can find a max value with the heap filling loop. The res
    array will preserve the lower bound of what just left the queue. The upper bound gets
    updated as we progress further into the list tagged by what was just polled. The loop
    breaks if you do a poll and don't do an offer. It seems unusual that introducing
    candidates for currMax randomly like this would produce the tightest upper bound, but
    the window res[0], res[1] is never actually increasing even if currMax might be. The
    min heap is constantly pushing larger numbers on the lower bound.

 */
public class SmallestRangeFromAllK_632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0]) // ? alternative to (a,b) -> a[0] - b[0]?
        );

        int currMax = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            minHeap.offer(new Integer[] {nums.get(i).get(0), i, 0});
            currMax = Math.max(currMax, nums.get(i).get(0));
        }

        int[] res = new int[] {0, Integer.MAX_VALUE}; // don't set to min, max lol

        while (minHeap.size() == k) {
            Integer[] min = minHeap.poll();
            int val = min[0];
            int list = min[1];
            int idx = min[2];

            if (currMax - val < res[1] - res[0]) {
                res[0] = val;
                res[1] = currMax;
            }

            if (idx + 1 < nums.get(list).size()) {
                Integer[] next = new Integer[]{ nums.get(list).get(idx + 1), list, idx + 1};
                minHeap.offer(next);
                currMax = Math.max(currMax, next[0]); //
            }
        }
        return res;
    }
}
