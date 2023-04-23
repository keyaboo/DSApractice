package com.leetcode.badstrategies;


import java.util.ArrayList;

import static com.leetcode.suboptimalsolutions.NumClosedIslands_1254.print2D;

/**
 * variation of the flood fill problem - ehh sort of
 * [y][x] is how we want to order the loop
 *
 * first submission got an infinite loop
 *
 * Definitely need to reread DFS recursion because so many calls I suspect are wasted.
 * DFS iterative with queues it's about time I did some problems with those too.
 */
public class Matrix01_542 {
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] update = updateMatrix(mat);
        print2D(update);
    }

    public static int[][] updateMatrix(int[][] mat) {
        int[][] updatedMatrix = new int[mat[0].length][mat.length];
        for (int y = 0; y < mat.length; y++) {
            for (int x = 0; x < mat[0].length; x++) {
                if (mat[y][x] == 1) {
                    updatedMatrix[y][x] = traverseForZeros(mat, x, y);
                }
            }
        }
        return updatedMatrix;
    }

    public static Integer traverseForZeros(int[][] mat, int x, int y) {
         if (mat[y][x] == 0) {
            return 0;
        } else if (y + 1 >= mat.length || y - 1 < 0 || x + 1 >= mat[0].length || x - 1 < 0) {
            return Integer.MAX_VALUE - 1; // Integer overflow concern.
         } else {
             int xInc = 1 + traverseForZeros(mat, x + 1, y);
             int xDec = 1 + traverseForZeros(mat, x - 1, y);
             int yInc = 1 + traverseForZeros(mat, x, y + 1);
             int yDec = 1 + traverseForZeros(mat, x, y - 1);

             return Math.min(xInc, Math.min(xDec, Math.min(yInc, yDec)));
        }
    }

}
