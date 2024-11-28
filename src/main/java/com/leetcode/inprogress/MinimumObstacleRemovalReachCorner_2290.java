package com.leetcode.inprogress;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Dijkstras problem - not to be confused with variation of number of steps algorithm because there's
no "cost" for movement, the cost is in removing an obstacle. In a regular Dijkstra's implementation,
the priority queue typically holds (node, cost) pairs just like this removal problem. Can store this
all in an array where node is (row, col), cost.
 */
public class MinimumObstacleRemovalReachCorner_2290 {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};

        int[][] minObstacles = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minObstacles[i][j] = Integer.MAX_VALUE;
            }
        }
        minObstacles[0][0] = grid[0][0]; // if first spot is filled this'll be a 1, 0 otherwise
        // equivalent to (a, b) -> a[0] - b[0]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] {minObstacles[0][0], 0, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int obstacles = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == m - 1 && col == n - 1) {
                return obstacles; // early stopping
            }
            for (int[] dir : directions) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if (isValid(grid, newRow, newCol)) {
                    int newObstacles = obstacles + grid[newRow][newCol];
                    if (newObstacles < minObstacles[newRow][newCol]) {
                        minObstacles[newRow][newCol] = newObstacles;
                        pq.add(new int[] {newObstacles, newRow, newCol});
                    }
                }

            }
        }
        return minObstacles[m-1][n-1];
    }

    private boolean isValid(int[][] grid, int row, int col) {
        return (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length);
    }
}
