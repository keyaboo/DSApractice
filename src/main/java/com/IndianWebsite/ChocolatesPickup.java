package com.IndianWebsite;

public class ChocolatesPickup {
    /*
        this problem wasn't intended to be solved with tabulation.
     */
    public int solve(int n, int m, int[][] grid) {
        Integer[][][] memo = new Integer[m][n][n];
        return dfs(0, 0, m-1, n, m, grid, memo);
    }

    public int dfs(int row, int col1, int col2, int n, int m, int[][] grid, Integer[][][] memo) {
        if (col1 < 0 || col1 == n || col2 < 0 || col2 == n) {
            return Integer.MIN_VALUE;
        }
        if (row == m) {
            return 0;
        }
        if (memo[row][col1][col2] != null) {
            return memo[row][col1][col2];
        }

        int maxChocolates = 0;
        for (int nextCol1 : new int[]{col1 - 1, col1, col1 + 1}) {
            for (int nextCol2 : new int[]{col2 - 1, col2, col2 + 1}) {
                if (nextCol1 == nextCol2) {
                    maxChocolates = Math.max(maxChocolates, grid[row][col1] + dfs(row+1, nextCol1, nextCol2, n, m, grid, memo));
                } else {
                    maxChocolates = Math.max(maxChocolates, grid[row][col2] + dfs(row+1, nextCol1, nextCol2, n, m, grid, memo));
                }
            }
        }
        return memo[row][col1][col2] = maxChocolates;
    }

/*
    public int solveTabulation(int n, int m, int[][] grid) {
        Integer[][][] dp = new Integer[n][m][m];
        int col1 = 0;
        int col2 = m - 1;
        dp[0][col1][col2] = grid[0][col1];
        dp[0][col2][col1] = grid[0][col2];
        int mostChocolates = 0;
        int[] prevColOffsets = new int[] {1, 0, 1};
        for (int row = 1; row < n; row++) {
            for (col1 = 0; col1 < m; col1++) {
                for (col2 = m-1; col2 >= 0; col2--) {
                    for (int prevColOffset1 : prevColOffsets) {
                        for (int prevColOffset2 : prevColOffsets) {
                            int prevCol1 = col1 + prevColOffset1;
                            int prevCol2 = col2 + prevColOffset2;
                            if (prevCol1 < 0 || prevCol1 >= m || prevCol2 < 0 || prevCol2 >= m) {
                                continue;
                            }
                            if (prevCol1 == prevCol2) {
                                dp[row][prevCol1][] = Math.max(dp[row][col1][col2], grid[row][col1] + grid[];
                            } else {
                                dp[row][col1][col2] = Math.max(dp[row][col1][col2], grid[row][col1] + grid[];
                            }
                        }
                }
                }
            }
        }
        return 0;
    }
*/

    public static int solveTab(int n, int m, int[][] grid) {
        Integer[][][] dp = new Integer[n][m][m];

            // Initialize first row of dp
        int[] colOffsets = new int[]{-1, 0, 1};
        int col1 = 0;
        int col2 = m -1;
        dp[0][col1][col2] = (col1 == col2) ? (grid[0][col1]) : (grid[0][col1] + grid[0][col2]);

            for (int row = 1; row < n; row++) {
                for (col1 = 0; col1 < m; col1++) {
                    for (col2 = m - 1; col2 >= col1; col2--) { // Iterate in ascending order
                        int maxPositionChocolates = 0;

                        for (int prevColOffset1 : colOffsets) {
                            for (int prevColOffset2 : colOffsets) {
                                int prevCol1 = col1 + prevColOffset1;
                                int prevCol2 = col2 + prevColOffset2;

                                if (prevCol1 >= 0 && prevCol1 < m && prevCol2 >= 0 && prevCol2 < m) {
                                    int currentChocolates = 0;
                                    if (col1 == col2) {
                                        currentChocolates = grid[row][col1];
                                    } else {
                                        currentChocolates = grid[row][col1] + grid[row][col2];
                                    }

                                    if (dp[row - 1][prevCol1][prevCol2] != null) {
                                        maxPositionChocolates = Math.max(maxPositionChocolates, currentChocolates + dp[row - 1][prevCol2][prevCol1]);
                                    }
                                }
                            }
                        }
                        dp[row][col1][col2] = maxPositionChocolates;
                    }
                }
            }

        // print3DMatrixAlongThirdAxis(dp);

        // Calculate mostChocolates after all calculations
        int mostChocolates = 0;
        for (col1 = 0; col1 < m; col1++) {
            for (col2 = 0; col2 < m; col2++) {
                mostChocolates = Math.max(mostChocolates, dp[n - 1][col1][col2]);
            }
        }
        return mostChocolates;
    }
    public static void print3DMatrixAlongThirdAxis(Integer[][][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int k = 0; k < m; k++) {  // Iterate along the third axis
            System.out.println("Matrix for k = " + k + ":");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matrix[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println("--------------------");
        }
    }


    public static void main(String[] args) {
        int n = 24;
        int m = 18;
        int[][] grid = {
                {4, 16, 7, 12, 26, 7, 11, 14, 15, 25, 8, 4, 13, 4, 23, 5, 20, 5},
                {13, 12, 2, 3, 11, 24, 3, 6, 9, 5, 9, 26, 8, 4, 3, 14, 8, 20},
                {20, 18, 4, 26, 12, 3, 29, 17, 6, 21, 13, 25, 17, 25, 6, 18, 20, 9},
                {3, 22, 14, 3, 18, 14, 20, 25, 18, 22, 30, 17, 12, 11, 4, 7, 6, 8},
                {9, 4, 24, 14, 24, 6, 1, 10, 23, 28, 20, 12, 6, 22, 25, 11, 25, 13},
                {25, 14, 29, 4, 28, 29, 20, 1, 9, 15, 29, 15, 22, 7, 10, 15, 12, 4},
                {13, 12, 5, 5, 2, 16, 8, 7, 8, 2, 18, 24, 14, 4, 29, 5, 7, 18},
                {25, 18, 10, 25, 2, 8, 9, 16, 6, 11, 30, 18, 6, 4, 21, 10, 8, 22},
                {26, 15, 21, 25, 17, 8, 10, 22, 3, 30, 18, 1, 10, 12, 18, 19, 7, 11},
                {27, 7, 26, 2, 17, 18, 11, 22, 21, 2, 24, 29, 15, 11, 5, 5, 27, 13},
                {4, 28, 5, 6, 27, 14, 6, 28, 26, 15, 17, 2, 26, 13, 30, 21, 6, 9},
                {8, 17, 30, 21, 10, 15, 19, 16, 17, 23, 21, 5, 6, 24, 2, 2, 22, 21},
                {15, 27, 18, 2, 12, 4, 25, 29, 8, 25, 19, 6, 3, 19, 22, 24, 9, 23},
                {1, 19, 8, 17, 3, 20, 14, 30, 6, 15, 23, 27, 27, 30, 15, 15, 1, 18},
                {10, 26, 16, 10, 12, 5, 15, 6, 15, 28, 21, 15, 20, 21, 3, 19, 30, 27},
                {9, 13, 27, 6, 19, 11, 2, 16, 10, 8, 30, 11, 26, 1, 28, 11, 10, 1},
                {7, 24, 6, 21, 13, 26, 27, 2, 9, 29, 13, 8, 18, 13, 12, 6, 18, 30},
                {16, 11, 15, 26, 18, 6, 28, 13, 7, 17, 16, 16, 9, 22, 2, 14, 5, 14},
                {1, 1, 8, 1, 22, 12, 30, 9, 24, 11, 14, 3, 3, 21, 13, 9, 8, 22},
                {15, 27, 27, 13, 13, 12, 20, 13, 25, 21, 26, 29, 27, 19, 30, 4, 19, 21},
                {15, 19, 21, 30, 21, 26, 2, 15, 16, 6, 24, 16, 19, 30, 12, 15, 12, 17},
                {18, 1, 29, 5, 14, 17, 3, 10, 27, 24, 13, 15, 6, 19, 25, 26, 18, 8},
                {13, 11, 22, 29, 8, 7, 6, 26, 6, 17, 3, 17, 25, 12, 10, 24, 16, 23},
                {2, 19, 2, 28, 12, 6, 4, 18, 24, 29, 5, 3, 28, 18, 5, 11, 8, 12}
        };

        int maxChocolates = solveTab(n, m, grid);
        System.out.println("Maximum chocolates collected: " + maxChocolates);
    }

}
