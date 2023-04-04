package com.leetcode.badstrategies;

/**
 * this seems like a great opportunity for using recursion
 * cheating a little bit but here's a
 * https://www.geeksforgeeks.org/traverse-a-given-matrix-using-recursion/#
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
        return floodFillRecursive(image, sr, sc, image[sr][sc], color);
    }

    public static int[][] floodFillRecursive(int[][] image, int i, int j, int match, int color) {

        if (i + 1 < image.length) {
            if (image[i+1][j] == match){
                image = floodFillRecursive(image, i + 1, j, match, color);
            }
        } else if (j + 1 < image[0].length) {
            if (image[i][j + 1] == match){
                image = floodFillRecursive(image, i, j + 1, match, color);
            }
        }  else if (i - 1 > 0) {
            if (image[i-1][j] == match) {
                image = floodFillRecursive(image, i - 1, j, match, color);
            }
        }  else if (j - 1 > 0) {
            if (image[i][j - 1] == match) {
                image = floodFillRecursive(image, i, j - 1, match, color);
            }
        }
        // this should be more of a swap?
        if (image[i][j] == match) {
            image[i][j] = color;
        }
        return image;
    }
}
