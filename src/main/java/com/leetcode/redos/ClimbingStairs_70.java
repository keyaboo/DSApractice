package com.leetcode.redos;

import java.util.Arrays;
import java.util.Stack;

/*
dp backtracking have a memo array of size n. Your two options are to consume or to

don't need a separate index.

memo[index] = climbStairs(memo, index + 1) + climbStairs(memo, index + 2);
^ LLM garbage glad I looked at the solution instead.

this is not intuitive
I didn't think you needed the check for memo[index] != 0 but you're not actually utilizing the memo table without.

ok time to be very deliberate about describing this problem's recurrence relationship.
 */
public class ClimbingStairs_70 {
    public int climbStairsMemoRecursion(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, 0);
        return climbStairsMemoRecursion(memo, n);
    }

    public int climbStairsMemoRecursion(int[] memo, int index) {
        if (index < 0) { // don't need this because base case of 1 already taken care of.
            return 0;
        }
        if (index == 0 || index == 1) {
            return 1;
        }
        if (memo[index] != 0) {
            return memo[index];
        }
        memo[index] = climbStairsMemoRecursion(memo, index - 1) + climbStairsMemoRecursion(memo, index - 2);
        return memo[index];
    }

    /*
    This was the approach I had in mind but conflated the commentary from the coin change recursion relation video.
    Why the dp arrays are the size they are based on the problem statement. Why arr[1] = 1 you can hardcode, and want
    to hardcode based on the problem statement. Interestingly, the iterative memoization computes memo[1] instead.
     */
    public int climbStairsTabulation(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /*
    memoization is top-down

    for dp hardcoding, it's acceptable to hardcode base cases or initial values that are directly derived from the
    problem statement. These are the starting points for the algo to build upon.

    Memoization, when implemented with recursion, generally follows a depth-first traversal. Then it backtracks
    and fills up the memoization table.
     */

    public int climbStairsMemoIterative(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, 0);
        memo[0] = 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (index > n) { // need this because it is a real possibility in this scenario
                continue;
            }
            if (memo[index] != 0) {
                continue;
            }
            if (index + 1 <= n && memo[index + 1] == 0) {
                stack.push(index + 1);
            }
            if (index + 2 <= n && memo[index + 2] == 0) {
                stack.push(index + 2);
            }
            if (index + 1 <= n && index + 2 <= n && memo[index + 1] != 0 && memo[index + 2] != 0) {
                memo[index] = memo[index + 1] + memo[index + 2];
            } else {
                stack.push(index);
            }
        }
        return memo[n];
    }


}
