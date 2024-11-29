package com.leetcode.accepted;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Priority queue bfs just like the last problem perhaps. There's similarities with the traversal except
backtracking has a clever solution in order to achieve progression. Wasting steps involves going back
to an old value but a node isn't added back to the previously traversed position. In order to preserve
the number of steps encountered so far, you compare next position val with the presence/absence of a wait
step to the current number of steps encountered so far. The priorityqueue takes care of the shortest
path. The ensuring right or bottom movement at the beginning is the reason for the constraint on grid
being at least 2 by 2, can be done outside the djikstra loop.

I made a mistake with the is valid method.
 */
public class MinimumTimeVisitCell_2577 {

    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] traversed = new boolean[m][n];
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] startingPoint = new int[] {0, 0, 0};
        pq.offer(startingPoint);
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int i = curr[1];
            int j = curr[2];
            if (i == m-1 && j == n-1) {
                return cost;
            }
            if (traversed[i][j]) {
                continue;
            }
            traversed[i][j] = true;

            for (int[] direction : directions) {
                int newi = i + direction[0];
                int newj = j + direction[1];
                if (isValid(traversed, newi, newj)) {
                    int difference = grid[newi][newj] - cost;
                    int wait = (difference % 2 == 0) ? 1 : 0;
                    int nextSteps = Math.max(cost+1, grid[newi][newj] + wait);
                    pq.add(new int[] {nextSteps, newi, newj});
                }
            }
        }
        return -1;
    }

    public boolean isValid(boolean[][] visited, int i, int j) {
        if (i >= 0 && j >= 0 && i < visited.length && j < visited[0].length && !visited[i][j]) return true;
        return false;
    }



}
