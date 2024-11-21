package com.leetcode.accepted;

public class CountUnguardedCellsInGrid_2257 {
    /*
    Don't look for valid squares look for invalid squares and subtract off m * n + walls + guards I would think.
    the orange problem might be similar to this. No it's so much easier to just to pass the grid in and then loop
    over everything to find 0's or whatever.

    edit: I wasn't thinking about the base case so dfs never ran once.
    this doesn't seem like we can use the grid border for information like in set matrix zeroes.
    What this did have in common with the set matrix zeroes is that we didn't want to possibly lose information
    in our marking strategy.
     */
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] guard : guards) grid[guard[0]][guard[1]] = 2;
        for (int[] wall : walls) grid[wall[0]][wall[1]] = 1;
        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] guard : guards) {
            for (int i = 0; i < directions.length; i++) {
                dfs(grid, guard[0] + directions[i][0], guard[1] + directions[i][1], m, n, directions, i);
            }
        }
        int unBlocked = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) unBlocked++;
            }
        }
        return unBlocked;
    }

    // recursive base case outside of bounds return 0.
    public void dfs(int[][] grid, int i, int j, int m, int n, int[][] directions, int direction) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] > 0) {
            return;
        }
        grid[i][j] = -1 + (-1 * direction);
        int inew = i + directions[direction][0];
        int jnew = j + directions[direction][1];
        dfs(grid, inew, jnew, m, n, directions, direction);
    }

}
