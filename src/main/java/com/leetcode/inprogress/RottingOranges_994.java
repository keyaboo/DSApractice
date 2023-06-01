package com.leetcode.inprogress;

/**
 * same recursive dfs approach
 */
public class RottingOranges_994 {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        for (int x = 0; x < grid[0].length; x++) {
            for (int y = 0; y < grid.length; y++) {
                if (grid[y][x] == 2) {
                    minutes = Math.max(minutes, dfs(grid, 0, x, y));
                }
            }
        }

        for (int x = 0; x < grid[0].length; x++) {
            for (int y = 0; y < grid.length; y++) {
                if (grid[y][x] == 1) {
                    return -1;
                }
            }
        }
        return minutes;
    }

    public static int dfs(int[][] grid, int currentTime, int x, int y) {
        if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) {
            return 0;
        }
        if (grid[y][x] == 0) {
            return 0;
        } else
        if (grid[y][x] == 1) {
            grid[y][x] = 2;
            int left = dfs(grid, currentTime, x-1, y);
            int right = dfs(grid, currentTime, x+1, y);
            int up = dfs(grid, currentTime, x, y+1);
            int down = dfs(grid, currentTime, x, y-1);
            currentTime = 1 + currentTime + Math.max(left, Math.max(right, Math.max(up, down)))
        }
        return currentTime;
    }
}
