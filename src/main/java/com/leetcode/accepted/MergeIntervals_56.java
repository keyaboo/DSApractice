package com.leetcode.accepted;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * alright this one turned out okay, really similar to the insert interval problem, most solutions don't attempt
 * any sort of -1, -1 interval as a baseline but the reassignment strategy and final drop off of the most recent
 * interval outside the loop works more or less.
 */
public class MergeIntervals_56 {

    public static void main(String[] args) {
        int[][] intervals = new int[2][2];
        intervals[0] = new int[] {1,4};
        intervals[1] = new int[] {4,5};
        merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        // the part where i cheat on the sort, need to make an anki card for this or something.
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        ArrayList<int[]> res = new ArrayList<>();
        int[] prevInterval = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (i == 0) {
                prevInterval = interval;
                continue;
            } else {
                if (interval[0] <= prevInterval[1]) {
                    interval = new int[] {prevInterval[0], Math.max(interval[1], prevInterval[1])};
                } else {
                    res.add(prevInterval);
                }
            }
            prevInterval = interval;
        }
        res.add(prevInterval);
        int[][] arr = new int[res.size()][2];
        arr = res.toArray(arr);
        return arr;
    }
}
