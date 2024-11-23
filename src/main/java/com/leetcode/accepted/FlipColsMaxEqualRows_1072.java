package com.leetcode.accepted;

import java.util.Arrays;
import java.util.HashMap;

public class FlipColsMaxEqualRows_1072 {
    /*
    flip criteria?
    possibly rows that mirror each other or are equal. example 3 you could easily flip C3 for the same effect.
    also if there are no mirror rows, find the most uneven row.
    I'm thinking maybe hashmap where you could store the row as a string for both variations, value could be the
    frequency.
    In fact there's nothing other than mirror arrays that needs to be known here, by default it should return 1
    since you're not restricted in the amount of flips and you could make any 1 row uniform.

    very slow, wow.
    ok, alternative approaches is to have a normalized first element (if row[0] == 1, you reverse the row or w/e)
    bit manipulation breaks down for large test cases unfortunately. the arrays.toString is worse than stringbuilder.
     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> freqs = new HashMap<>();
        int n = matrix[0].length;
        int max = 1;
        for (int[] row : matrix) {
            if (row[0] == 1) { // flip only these kinds of rows
                for (int i = 0; i < n; i++) {
                    row[i] = 1 - row[i];
                }
            }
            String orig = Arrays.toString(row);
            freqs.put(orig, freqs.getOrDefault(orig, 0) + 1);
            max = Math.max(max, freqs.get(orig));
        }
        return max;
    }
}
