package com.leetcode.badstrategies;

import java.util.ArrayList;

/**
 * output should always be shorter than input
 * [1 2] [3 5] [6 7] [90 100]
 * [4 42]
 *
 * took some stabs at this, going to just look at the solution because one of the test cases I'd get correct
 * and the other I wouldn't depending on how it was written up.
 *
 */
public class InsertInterval_57 {

        public int[][] insert(int[][] intervals, int[] newInterval) {
            ArrayList<int[]> output = new ArrayList<>();
            int newIntervalMin = newInterval[0];
            int newIntervalMax = newInterval[1];
            int[] interval = new int[2];
            for (int i = 0; i < intervals.length; i++) {
                if (intervals[i][0] > newIntervalMin && intervals[i][1] < newIntervalMax) {
                    continue; // pass over the in-between ranges
                } if (intervals[i][1] < newIntervalMin || intervals[i][0] > newIntervalMax ) {
                    output.add(intervals[i]); // should capture everything outside the range
                } else {
                    int lowBound = Math.min(intervals[i][0], newIntervalMin);
                    interval[0] = lowBound;
                    interval[1] = newIntervalMax;
                    output.add(interval);
                }
            }
            int[][] solution = new int[output.size()][2];
            solution = output.toArray(solution);
            return solution;

        }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> output = new ArrayList<>();
        int newIntervalMin = newInterval[0];
        int newIntervalMax = newInterval[1];
        int[] interval = new int[2];
        boolean intervalStarted = false;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > newIntervalMin && intervals[i][1] < newIntervalMax) {
                continue; // pass over the in-betweens
            } if (intervals[i][1] < newIntervalMin || intervals[i][0] > newIntervalMax ) {
                output.add(intervals[i]); // should capture everything
            } else if (!intervalStarted){
                int lowBound = (intervals[i][0] < newIntervalMin) ? intervals[i][0] : newIntervalMin;
                interval[0] = lowBound;
                intervalStarted = true;
            } else {
                int highBound = (intervals[i][1] > newIntervalMax) ? intervals[i][1] : newIntervalMax;
                interval[1] = highBound;
                output.add(interval);
            }
        }
        int[][] solution = new int[output.size()][2];
        solution = output.toArray(solution);
        return solution;
    }







}
