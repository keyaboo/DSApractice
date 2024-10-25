package com.leetcode.accepted;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
    have a hashset that stores strings. Don't let the names possibly conflate. This could just as easily have been
    2 loops from 0-9, the subbox granularity it turns out was not needed. Building strings and having 4 loops like
    this is obviously pretty slow.
 */
public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> found = new HashSet<String>();
        for (int subBlockMultiple1 = 0; subBlockMultiple1 < 3; subBlockMultiple1++ ) {
            for (int subBlockMultiple2 = 0; subBlockMultiple2 < 3; subBlockMultiple2++) {
                int iStart = 3 * subBlockMultiple1;
                int jStart = 3 * subBlockMultiple2;
                for (int i = 3 * subBlockMultiple1; i < 3 + iStart; i++) {
                    for (int j = 3 * subBlockMultiple2; j < 3 + jStart; j++) {
                        if (board[i][j] != '.') {
                            String row = "r" + i + "_" + board[i][j]; // make sure to give these prefixes.
                            String col = "c" + j + "_" + board[i][j];
                            String box = "b" + (i / 3) + "_" + (j / 3) + "_" + board[i][j];
                            if (!found.add(row) || !found.add(col) || !found.add(box)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
