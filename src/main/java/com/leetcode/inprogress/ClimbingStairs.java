package com.leetcode.inprogress;

import java.util.HashMap;

/**
 * fibonacci example had a hashmap be an environment variable, this is the first DP problem I've
 * encountered
 * https://www.interviewcake.com/concept/java/memoization
 * the logic here could be:
 * n = 1 -> 1 way, store in the map, we want to constantly refer to this 1 - 1 = 0 this can be the check
 * n = 2 -> 2 - 2 = 0 perhaps this could be another check, 2 - 1 = 1 refer to above
 * n = 3 -> 3 - 2 = 1 refer to first, increment since > 1
 * n = 4 -> 4 - 2 = 2 is an increment, 4 - 1 = 3 is another increment, but what to store exactly
 * when this happens I guess you add the saved function values of 2 and 3?
 *
 * gonna do this problem with pen and paper to organize my thoughts.
 */
public class ClimbingStairs {
    public static void main(String[] args) {

    }

    public static int climbStairs(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int maxBlocksOfTwo = n / 2;
        for (int i = maxBlocksOfTwo; i >= 0; i--) {
            findSteps(n - (2*i), memo);
        }
        return 0;
    }

    public static int findSteps(int n, HashMap<Integer, Integer> memo) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        return 0;
    }
}
