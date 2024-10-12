package com.leetcode.guided.set1;

import java.util.Arrays;
import java.util.HashMap;

/*
    the sort of naive approach is to parse the entirety of the matrix, check for 0's and keep track of where.
    Instead, can keep count of cols that are zero same as before, but when encountering a 0
    on the first loop pass, reassign the entire row of matrix at index i to be a new array full of zeroes.
    Break afterwards since there's no need to look at that row anymore.
    Then loop over the colZeroes array, and if a particular index evaluates to true, loop over the
    rows and reassign all to zero.


    Alternatively one can use the top and left sides of the matrix itself to mark for filling. A
    problem presents itself where matrix[0][0] could be assigned to 0 because of a scan of the first
    row or the first column. Just create a temporary variable col0 to be false by default, set to
    true if a 0 is found in the first column, and have an extra step to 0-out the first col if true.

 */
public class SetMatrixZeroes_73 {

    public void setZeroes(int[][] matrix) {
        Boolean col0 = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark a 0 column in the top row
                    if (j == 0) {
                        col0 = true;
                    } else {
                        matrix[0][j] = 0; // mark a 0 row in the leftmost column
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) { // scanning first row
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (col0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 1;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


        public void setZeroesSlow(int[][] matrix) {
        Boolean[] rowZeroes = new Boolean[matrix.length];
        Boolean[] colZeroes = new Boolean[matrix[0].length];
        Arrays.fill(rowZeroes, false);
        Arrays.fill(colZeroes, false);
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    rowZeroes[i] = true;
                    colZeroes[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rowZeroes[i] || colZeroes[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }



}
