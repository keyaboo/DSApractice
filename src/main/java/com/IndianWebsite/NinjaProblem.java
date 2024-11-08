package com.IndianWebsite;

/*
so with, eg the climbing stairs problem, you see recursive calls to subproblems done in one statement.
like:     memo[index] = climbStairsMemoRecursion(memo, index - 1) + climbStairsMemoRecursion(memo, index - 2);
but here it's done in a loop which is how the different activities constraint is imposed.
for this ninja problem, memo array is 2D because the subproblem is defined by the day and the activity.

if you wanted to find the maximum points for 7 activities in 7 days with no repeated activities ever, can
use either a hashmap with key day, hashset activities representing those already performed OR
with bitmasking. The bitmask would be applied to where you see int[n][1 << k] or whatever and instead of giving
param as a fixed activity. also the size of the array is 2^k so rip space efficiency.

subproblems for this and climbing stairs:
CS: what's minimum no ways to reach i-th step, and the solution depends on the solutions for the i-1 and i-2th steps
Ninja: maximum number of points can be earned on day i if activity j is performed on that day, where it's going
to depend on the solution for day i -1 for the activities which aren't j given the no repeat constraint.
 */
public class NinjaProblem {
    public int maximumPoints(int arr[][], int N) {
        int n = arr.length;
        Integer[][] memo = new Integer[n][3];
        int maxPoints = 0;
        for (int i = 0; i < 3; i++) {
            maxPoints = Math.max(maxPoints, dfs(n-1, i, arr, memo));
        }
        return maxPoints;
    }

    public int dfs(int row, int activity, int[][] arr, Integer[][] memo) {
        if (row == 0) {
            return arr[0][activity];
        }
        if (memo[row][activity] != null) {
            return memo[row][activity]; // always check if current subproblem is already in memo array
        }
        int mostPoints = 0;
        for (int j = 0; j < 3; j++) {
            if (j != activity) {
                mostPoints = Math.max(mostPoints, dfs(row - 1, j, arr, memo));
            }
        }
        return memo[row][activity] = arr[row][activity] + mostPoints;
    }

}
