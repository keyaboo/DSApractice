package com.leetcode.accepted;

import java.util.ArrayList;
import java.util.List;

public class Triangle_120 {
    /*
    subproblem is: at a particular row, the column val is going to be the minimum of same col previous row and
    whatever's to the right of that.
    you don't need to build rowi ever. just like unique paths
     */

    public int minimumTotal(List<List<Integer>> triangle) {
        int sideLength = triangle.size();
        List<Integer> pathSums = new ArrayList<>(triangle.get(sideLength - 1));
        for (int i = sideLength - 2; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                int shortest = Math.min(pathSums.get(j), pathSums.get(j+1));
                pathSums.set(j, shortest + triangle.get(i).get(j));
            }
        }
        return pathSums.get(0);
    }

    /*
    runtime for the above was a little slow, memo dfs is crazy fast
     */
    public int minimumTotalMemo(List<List<Integer>> triangle) {
        int sideLength = triangle.size();
        Integer[][] memo = new Integer[sideLength][sideLength];
        return dfs(0,0, triangle, memo);
    }

    public int dfs(int row, int col, List<List<Integer>> triangle, Integer[][] memo) {
        if (memo[row][col] != null) {
            return memo[row][col]; // prevents OOB for col + 1 dfs call below AND redundant calculations
        }
        int path = triangle.get(row).get(col);
        if (row < triangle.size() - 1) {
            path += Math.min(dfs(row + 1, col, triangle, memo), dfs(row + 1, col + 1, triangle, memo));
        }
        return memo[row][col] = path;
    }
}
