package com.leetcode.guided.set1;

import java.util.Arrays;
import java.util.HashMap;

/*
    the sort of naive approach is to parse the entirety of the matrix, check for 0's and keep track of
    where with created n,m sized marker matrices. Probably don't use the marker matrices for looping,
    another full pass of matrix and then checking the marker matrices for either row or column zeroes
    is as good of an approach for filling as any.

    Alternatively one can use the top and left borders of the matrix itself to mark for filling. A
    problem presents itself where matrix[0][0] could be assigned to 0 based on a 0 appearing in either
    the first row or the first column. Just create a temporary variable col0 to be false by default, set
    to true if a 0 appears in the first column, don't mark matrix[0][0] equal to 0 if an element
    of matrix[i][0] is found to be zero since that's the marker for row 0 information. The zeroing
    out process has to take place starting from (1,1) up to (n-1, m-1) because the border entries are
    already zero. Space complexity for this approach is obviously O(1).

    I made numerous notation mistakes looping and indexing so I included a refresher below.

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
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) { // could just be Arrays.fill(matrix[0], 0)
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
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

    /*
    I've forgotten a lot about LC matrices. Refresh:
    - counter i corresponds to the row index and matrix.length
    - counter j corresponds to column index and matrix[0].length
    - matrix[0][0] = 1 (row 0, column 0)
    - matrix[1][2] = 6 (row 1, column 2)
    - n is associated with number of rows
    - m is associated with number of columns
    - int[][] matrix = new int[n][m];
     */
    private class LeetcodeMatrix {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

    }

}
