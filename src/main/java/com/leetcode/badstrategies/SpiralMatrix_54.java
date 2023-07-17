package com.leetcode.badstrategies;

import java.util.ArrayList;
import java.util.List;
/*
    anticipating where this is going to get messed up
    first mess up is with indices. not going to spend any more time editing this
 */
public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length + 1][matrix[0].length + 1];
        List<Integer> res = new ArrayList<>();
        int cells = matrix[0].length * matrix.length;
        int x = 0, y = 0;
        int xshift = 1; int yshift = 0;

        for (int i = 0; i < cells; i++) {
            visited[y][x] = true;
            res.add(matrix[y][x]);

            if ((x + xshift == matrix[0].length || visited[y][x + xshift]) && xshift == 1 ) { // moving right and then down
                xshift = 0;
                yshift = +1;
            } else if (((x + xshift < 0 && y > 0) || visited[y][x + xshift]) && xshift == -1) { // at the bottom swinging up, origin edge case
                xshift = 0;
                yshift = -1;
            } else if ((y + yshift == matrix.length || visited[y + yshift][x]) && yshift == 1) { // at the bottom swinging left
                xshift = -1;
                yshift = 0;
            } else if ((visited[y + yshift][x]) && yshift == -1) { // at the top
                xshift = 1;
                yshift = 0;
            }
            x += xshift;
            y += yshift;

        }
        return res;
    }
}
