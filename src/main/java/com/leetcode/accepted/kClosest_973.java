package com.leetcode.accepted;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * forgot a rather famous math trick that when you're using norms for comparison, you don't need to take
 * the square root. Comparator functions, either with lambdas or overrides, are unavoidable like I found out
 * with my previous attempt at this.
 *
 * * I messed up the order of the Double comparator fn params in my stupid little point class.
 * But some lessons here:
 *  * 1) when points are given as addresses x,y, in a multidimensional array make use of
 *  the various ways you can loop with or build containers out of <int[]>, e.g. Queue<int[]>,
 *  for (int[] p : points), what have you.
 *  2) when doing custom comparators, always do subtraction with fn param 2 - fn param 1
 *
 *
 */
public class kClosest_973 {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1];
            }
        });

        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        while (k > 0) { // this sort of loop I need more practice with.
            res[--k] = maxHeap.poll();
        }
        return res;
    }
}
