package com.leetcode.accepted;

/**
 * ok so the slightly faster solutions don't use a boolean visited matrix, they just changed 1's to 0s in the dfs
 * function. whatever good enough.
 */
public class NumberOfIslands_200 {
    public int numIslands(char[][] grid) {
        int ymax = grid.length; // y's
        int xmax = grid[0].length; // x's
        boolean[][] visited = new boolean[ymax][xmax];
        int islandCount = 0;
        for (int i = 0; i < ymax; i++) {
            for (int j = 0; j < xmax; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islandCount++;
                    dfs(visited, grid, i, j, ymax, xmax);
                }
            }
        }
        return islandCount;
    }

    public void dfs(boolean[][] visited, char[][] grid, int y, int x, int ymax, int xmax) {
        if (y < 0 || y >= ymax || x < 0 || x >= xmax) {
            return; // this makes you appreciate the difference between > and >=
        }
        if (visited[y][x]) {
            return;
        }
        if (grid[y][x] == '1') {
            visited[y][x] = true;
            dfs(visited, grid, y+1, x, ymax, xmax);
            dfs(visited, grid, y-1, x, ymax, xmax);
            dfs(visited, grid, y, x+1, ymax, xmax);
            dfs(visited, grid, y, x-1, ymax, xmax);
        }
    }

}
