package com.leetcode.inprogress;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
First use a creative sort to get the ordered intervals by start term - end order does not
matter. Create a minheap based on the end interval values, priorityqueue is min by default.
Populate the heap with the first end term in now sorted intervals. Every number added to the
queue represents an overlapping interval. In the loop, the heap's peek (smallest end val)
is compared against the start term of interval at loop index. If the start term exceeds,
there's a candidate pair for belonging to the same group, poll the queue. Ultimately,
the queue is a collection of right terms for overlapping intervals, and the return.
 */
public class DivideIntervalsMinGroups_2406 {
    public int minGroups(int[][] intervals) {
        Integer[] index = new Integer[intervals.length];
        Arrays.sort(intervals, (a, b) ->
                {
                    int firstCompare = a[0] - b[0];
                    if (firstCompare != 0) {
                        return firstCompare;
                    } else {
                    return a[1] - b[1]; // unnecessary extra sort step
                    }
                }
                );
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);
        for (int i = 1; i < index.length; i++) {
            if (minHeap.peek() < intervals[i][0]) {
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }
}
