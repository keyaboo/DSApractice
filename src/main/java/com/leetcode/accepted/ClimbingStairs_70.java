package com.leetcode.accepted;

import java.util.HashMap;

/**
 * fibonacci example had a hashmap be an environment variable, this is the first DP problem I've
 * encountered but so far so good
 * https://www.interviewcake.com/concept/java/memoization
 * the logic here could be:
 * n = 1 -> 1 way, store in the map, we want to constantly refer to this 1 - 1 = 0 this can be the check
 * n = 2 -> 2 - 2 = 0 perhaps this could be another check, 2 - 1 = 1 refer to above
 * n = 3 -> 3 - 2 = 1 refer to first, increment since > 1
 * n = 4 -> 4 - 2 = 2 is an increment, 4 - 1 = 3 is another increment, but what to store exactly
 * when this happens I guess you add the saved function values of 2 and 3?
 * the breakup of 4 should be
 * 4 - 1 = 3 **I think add 1 to whatever the function returns for 3** <- this is what you don't want to do but it made sense at the time.
 * 4 - 2 = 2 also add 1 to whatever the function returns for 2
 * gonna do this problem with pen and paper to organize my thoughts.
 *
 * 4
 * __ __
 * _ __ _
 * _ _ __
 * __ _ _
 * _ _ _ _
 * ok this does seem right
 *
 * notes for this:
 * 1) don't put a recursive function inside of a loop (duh)
 * 2) with fib for example, int result = fib(n - 1) + fib(n - 2); is the way it's represented
 * there's really no reason to do a result = 1 + recursivefunction() or whatever, which was messing
 * with how things were being done
 */
public class ClimbingStairs_70 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        // totally optional
//        memo.put(0,0);
//        memo.put(1,1);
        int total = findSteps(n, memo);;
        return total;
    }
    public static int findSteps(int n, HashMap<Integer, Integer> memo) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        // in theory this isn't necessary just check the table with the lines that are commented out

        // then checking the map seems like an obvious thing to do
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        // then we start dealing with new possibilities
        int total = 0;
        if (n - 1 > 0) {
            total = total + findSteps(n - 1, memo);
        }
        if (n - 2 > 0) {
            total = total + findSteps(n - 2, memo);
        } else if (n - 2 == 0) {
            total = total + 1;
        }
        memo.put(n, total);
        return total;
    }
}
