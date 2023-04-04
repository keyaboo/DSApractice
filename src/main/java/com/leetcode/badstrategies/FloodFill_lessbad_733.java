package com.leetcode.badstrategies;

import java.util.*;

/**
 * Looking into the breadth first search algorithm for efficient traversal.
 * This deals with the infinite loop problem I was having
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/#
 *
 *
 * This one did not get a very impressive time score nor memory score.
 *
 * Some areas of improvement, the traverse function does not need to return the image, since the pointer to it
 * is already in the function argument and it's getting overwritten the same way my unnecessary hashset happens to be.
 * for checking what you've already done, you can have a boolean matrix [][], the default value for boolean is false
 * which the compiler would normally yell at you for not initializing but in the context of arrays with fixed lengths
 * that isn't really a problem.
 */
public class FloodFill_lessbad_733 {

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] answer = floodFill(image, 1, 1, 2);
//        boolean[] hello = new boolean[1];
//        System.out.println(hello[0]);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        ArrayList<Integer> start = new ArrayList<Integer>(Arrays.asList(sr, sc));
        Set<ArrayList<Integer>> visited = new HashSet<>();
        return floodFillRecursive(image, sr, sc, image[sr][sc], color, visited);
    }

    public static int[][] floodFillRecursive(int[][] image, int i, int j, int match, int color,
                                             Set<ArrayList<Integer>> visited) {
        image[i][j] = color;
        visited.add(new ArrayList<>(Arrays.asList(i, j)));
        image = traverse(image, i, j, match, color, visited);
        image = traverse(image, i + 1, j, match, color, visited);
        image = traverse(image, i - 1, j, match, color, visited);
        image = traverse(image, i, j + 1, match, color, visited);
        image = traverse(image, i, j - 1, match, color, visited);
        return image;
    }

    public static int[][] traverse(int[][] image, int i, int j, int match, int color,
                                   Set<ArrayList<Integer>> visited) {
        if (i < image.length && i >= 0 && j < image[0].length && j >= 0 && !visited.contains(Arrays.asList(i, j))) {
            if (image[i][j] == match) {
                visited.add(new ArrayList<>(Arrays.asList(i, j)));
                image[i][j] = color;
                return floodFillRecursive(image, i, j, match, color, visited);
            }
        }
        return image;
    }



}
