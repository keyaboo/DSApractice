package com.leetcode.badstrategies;

public class GasStation_134 {
    /*
    preserving the surplus computation in an array is a waste of space.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] surplus = new int[n];
        int surplusVar = 0;
        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            surplusVar += diff;
            surplus[i] = diff;
        }
        if (surplusVar != 0) {
            return -1;
        }
        int idx = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += surplus[i];
            if (sum < 0) {
                idx = i;
            }
        }
        return idx;
    }

}
