package com.leetcode.accepted;

import java.util.ArrayList;

/**
 * there was a really clever solution to this Greg and I looked at a week ago that involved reassignment of newinterval,
 * which is quite strange but a trick that would be good to get familiar with.
 * The outline of it was something like
 * for loop over all intervals
 * 1) if interval's highest val < newInterval's lowest val, add it to resulting array
 * then we get into the weird shit
 * 2) if intervals[i][1] is greater than the newInterval[0] and intervals[i][0] is less than newInterval[0],
 * reassign newinterval to [min(intervals[i][0], newInterval[0]), max(intervals[i][1], newInterval[1]). no insertion
 * takes place here.
 *
 * 3) if you reach the point where interval[i][0] > newInterval[1], insert newInterval into res, and reassign newInterval
 * to be whatever intervals[i] you're on.
 *
 * after the loop is done, you insert newInterval, irrespective of what max of the original newInterval looked like.
 *
 * I feel there was an OR for the third if where newInterval gets reassigned. I think I'm missing the case where
 * interval[0] > newInterval[0] but interval[1] < newInterval[1], so i'll add it
 *
 * |XXX|
 *    |YYYY|
 *        |ZZZZ|
 *
 * much easier to just draw a picture.
 *
 * forgot >= and <= in the last if, easy fix beats 97.5%
 */
public class InsertInterval_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        for (int[] interval:intervals) {
            if (interval[1] < newInterval[0]) {
                res.add(interval);
            } else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                newInterval = interval;
            } else if (interval[1] >= newInterval[0] && interval[0] <= newInterval[0]
                    || interval[0] <= newInterval[1] && interval[1] >= newInterval[1]) {
                newInterval = new int[] { Math.min(interval[0], newInterval[0]), Math.max(interval[1], newInterval[1])};
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][2]);
    }
}
