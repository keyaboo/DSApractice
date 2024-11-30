package com.leetcode.accepted;

public class MaximumMatrixSum_1975 {
    /*
    any number of times probably means just look for some pattern. Can look at 2 by 2 boxes, but that
    would be tedious. I bet it's just find the smallest absolute number in the entire matrix because you can
    keep moving the negative until it's at that spot. If the number of negatives modulo 2 is 0 then
    it's just the sum of the matrix, modulo 2 1 then the smallest value.

    I was careless about the fact that it isn't one times the smallest value it's 2 times it because
    you have to double count it away from your sum which included it.
     */
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0L;
        int smallest = Integer.MAX_VALUE;
        int negatives = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < 0) negatives++;
                sum += Math.abs(matrix[i][j]);
                smallest = Math.min(smallest, Math.abs(matrix[i][j]));
            }
        }
        return (negatives % 2 == 0) ? sum : (sum - 2*smallest);
    }

}
