package com.leetcode.accepted;

/*
this can be done with only a column vector so going to attempt that solution. The minimum is either going to be
coming from the left or above ('same').

Oh I didn't even include a base case, first row isn't a straight System.arraycopy like the falling problem.
Ok memo dfs is again faster but this is pretty easy to walk through.
 */
public class MinimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++) dp[j] = dp[j-1] + grid[0][j]; // HETEROGENEOUS
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j-1]) + grid[i][j];
            }
        }
        return dp[n-1];
    }

}
