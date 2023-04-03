package com.leetcode.inprogress;

/**
 * this seems like a great opportunity for using recursion
 * cheating a little bit but here's a
 * https://www.geeksforgeeks.org/traverse-a-given-matrix-using-recursion/#
 *
 *
 */
public class FloodFill_733 {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] answer= floodFill(image, 1, 1, 2);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startingValue = image[sr][sc];
        int width = image[0].length;
        int height = image.length;
        return null;
    }

    public static int[][] floodFillRecursive(int[][] image, int sr, int sc, int color) {
        if (sr + 1 == image.length) {
            //
        } else if (sr - 1 >= 0) {

        }
        return null;
    }
}
