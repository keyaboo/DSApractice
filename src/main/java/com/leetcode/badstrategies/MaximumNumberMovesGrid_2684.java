package com.leetcode.badstrategies;

import java.util.HashSet;
import java.util.Set;

/*
 */
public class MaximumNumberMovesGrid_2684 {
    public int maxMoves(int[][] grid) {
        int mostMoves = 0;
        for (int j = 0; j < grid[0].length; j++) {
            Set<int[]> visited = new HashSet<>();
            int moves = dfs(grid, 0, j, visited);
            mostMoves = Math.max(moves, mostMoves);
        }
        return mostMoves;
    }

    public int dfs(int[][] matrix, int i, int j, Set<int[]> visited) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited.contains(new int[] {i, j})) {
            return 0;
        }
        int count = 1;
        visited.add(new int[] {i, j});
        int right = 0;
        int bottomRight = 0;
        int topRight = 0;
        if (matrix[i][j+1] > matrix[i][j]) {
            right = dfs(matrix, i, j+1, visited);
        }
        if (matrix[i+1][j+1] > matrix[i][j]) {
            bottomRight = dfs(matrix, i+1, j+1, visited);
        }
        if (matrix[i-1][j+1] > matrix[i][j]) {
            topRight = dfs(matrix, i+1, j+1, visited);
        }
        return count + Math.max(right, Math.max(bottomRight, topRight));
    }
}
