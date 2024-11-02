package com.leetcode.accepted;

public class GasStation_134 {
    /*
    only thing I got wrong sort of was that a unique solution doesn't mean the total surplus of the cycle is
    zero. which means I had the ternary mixed up.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int surplus = 0;
        int cycleSurplus = 0; // I had this originally show up in the first loop but not necessary
        int index = 0;
        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            surplus += diff;
            cycleSurplus += diff;
            if (surplus < 0) {
                index = i + 1; // an improvement over last one that I got this right
                surplus = 0;
            }
        }
        return (cycleSurplus < 0) ? -1 : index; //
    }
}
