package com.leetcode.inprogress;

import java.util.Arrays;

public class UniquePathsII_63 {
    /*
    having both loops starting at 0 and asserting a range check semes preferable.
    The first column wasn't going to change for unique paths I, so it made sense to just not consider it and
    always have valid access to j-1, second loop starting at 1. but here, since it can change, the inner loop
    can take care of a blocked portion.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) dp[j] = 0;
                else if (j > 1){
                    dp[j] = dp[j] + dp[j-1];
                }
            }
        }

        return dp[n-1];
    }
}
