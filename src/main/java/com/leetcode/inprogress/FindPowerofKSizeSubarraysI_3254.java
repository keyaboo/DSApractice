package com.leetcode.inprogress;

import java.util.ArrayDeque;
import java.util.Deque;

/*
power is maximum element of consecutive subarray in ascending order, otherwise -1.
Could have a deque with fixed size. Treat it like a monotonic increasing stack. If size == k then poll.
 */
public class FindPowerofKSizeSubarraysI_3254 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> monoQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!monoQueue.isEmpty() && nums[i] > nums[monoQueue.peekLast()]) {
                monoQueue.pollLast();
            }
            monoQueue.offer(i);

            if (monoQueue.peekFirst() <= i - k) {
                monoQueue.pollFirst();
            }
            if (i >= k - 1) {
                if (monoQueue.size() == k) {
                    res[i - k + 1] = nums[monoQueue.peekFirst()];
                } else {
                    res[i - k + 1] = -1;
                }
            }
        }
        return res;
    }
}
