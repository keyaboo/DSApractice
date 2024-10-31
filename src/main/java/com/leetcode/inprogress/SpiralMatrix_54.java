package com.leetcode.inprogress;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Add to the traversed set the out of bounds stuff to change directions. At first I thought to simply add the oob
    coordinates to the hashset but that was a little tedious.
 */
public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] directions = new int[] {1, 0, 0, -1, -1, 0, 0, 1};
        Set<int[]> traversed = new HashSet<>();
        int[] oobRight = new int[] {0, m}; traversed.add(oobRight);
        int[] oobBottom = new int[] {n, m-1}; traversed.add(oobBottom);
        int[] oobLeft = new int[] {n-1,-1}; traversed.add(oobLeft);
        int[] oobBottomLeft = new int[] {n, 0}; traversed.add(oobBottomLeft);
        int i = 0;
        int j = 0;
        int dirIdx = 0;
        List<Integer> res = new ArrayList<>();
        while (canProceed(i, j, traversed)) {
            res.add(matrix[i][j]);
            if (dirIdx == 6 && !traversed.contains(new int[] {i+1, j})) {
                dirIdx = 0;
            } else if (traversed.contains(new int[] {i+dirIdx, j+dirIdx})) {
                dirIdx += 2;
            }
            int shiftX = directions[dirIdx];
            int shiftY = directions[dirIdx+1];
            i += shiftX;
            j += shiftY;
        }
        return res;
    }

    public boolean canProceed(int i, int j, Set<int[]> visited) {
        int[] arr1 = new int[] {i + 1, j};
        int[] arr2 = new int[] {i - 1, j};
        int[] arr3 = new int[] {i, j + 1};
        int[] arr4 = new int[] {i, j - 1};
        if (visited.contains(arr1) && visited.contains(arr2) && visited.contains(arr3) && visited.contains(arr4)) {
            return false;
        }
            return true;
    }

}
