package com.leetcode.inprogress;

import java.util.Arrays;

/*
Full grid sized dp array since I wouldn't learn as much doing this problem DFS/BFS as a memoization review. Start
looping over the second column of grid to see whether you have a strictly bigger term than the three adjacent.

Looking at the solution to see how the bounds were handled - oh that's literally the entire block of code is checking
bounds LOL.

Because you set 1 as a marker for validity and it doesn't represent a valid move the way adjacent dp values do,
maxMoves has to be decremented by 1.
 */
public class MaximumNumberMovesGrid_2684 {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxMoves = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        for (int i=0; i<n; i++) {
            dp[i][0] = 1; // first row all entries are reachable
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                int gridValue = grid[i][j];

                if (gridValue > grid[i][j-1] && dp[i][j-1] > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + 1);
                }
                if ((i - 1 >= 0) && (gridValue > grid[i-1][j-1] && dp[i-1][j-1] > 0)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
                if ((i + 1 < m) && (gridValue > grid[i+1][j-1] && dp[i+1][j-1] > 0)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i+1][j-1] + 1);
                }
                maxMoves = Math.max(maxMoves, dp[i][j] - 1);
            }
        }
        return maxMoves;
    }
}
