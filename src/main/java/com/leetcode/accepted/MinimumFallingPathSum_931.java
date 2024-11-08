package com.leetcode.accepted;

/*
dfs is faster, might implement some day
 */
public class MinimumFallingPathSum_931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                } else if (j == matrix.length - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i-1][j], dp[i-1][j+1]), dp[i-1][j-1]);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[n-1][j]); // made a mistake checking first row - this isn't memo
        }
        return min;
    }
}
