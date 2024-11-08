package com.leetcode.accepted;

import java.util.Arrays;

public class UniquePaths_62 {
    /*
    2D dp array: tabulation where a particular grid value is going to be equal to dp[i-1]dp[j-1]. maybe have
    the borders be filled out first. No don't do that, get comfortable with having base cases in your main loops.
    Also the border values should all be 1, I was incrementing along which led to numbers that were way too high.
    Okay that was too easy to be right and uses too much space.
     */
    public int uniquePathsBad(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else { dp[i][j] = dp[i-1][j] + dp[i][j-1]; }
            }
        }
        return dp[m-1][n-1];
    }
    // had a discussion with the AI where I broke up what would influence a grid value, coming from top, left, and TL
    // but top left info is preserved in top so you only need one array.
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] prev = dp;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j-1] + prev[j];
            }
            prev = dp;
        }
        return dp[n-1];
    } // there's no reason to have an extra array for the previous row.

}
