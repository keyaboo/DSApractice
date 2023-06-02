package com.leetcode.inprogress;

/**
 * same recursive dfs approach
 */
public class RottingOranges_994 {
    public int orangesRotting(int[][] grid) {
        int minutes = 2;
        for (int x = 0; x < grid[0].length; x++) {
            for (int y = 0; y < grid.length; y++) {
                if (grid[y][x] == 2) {
                    dfs(grid, 2, x, y);
                }
            }
        }
        for (int x = 0; x < grid[0].length; x++) {
            for (int y = 0; y < grid.length; y++) {
                if (grid[y][x] == 1) {
                    return -1;
                }
                minutes = Math.max(minutes, grid[y][x]);
            }
        }
        return minutes;
    }

    public void dfs(int[][] grid, int currentTime, int x, int y) {
        if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) {
            return;
        } else {
            grid[y][x] = currentTime;
            dfs(grid, currentTime+1, x-1, y);dfs(grid, currentTime+1, x+1, y);
            dfs(grid, currentTime+1, x, y+1);
            dfs(grid, currentTime+1, x, y-1);
        }
    }
}
