package com.leetcode.annotatedexamples;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.leetcode.suboptimalsolutions.NumClosedIslands_1254.print2D;

/**
 * the thing about this problem that would have kept me from coming up with a solution like these
 * is the conflation (but not really) of values and distances. But really there's no reason target
 * '42' 't' or whatever could not be overwritten with '0' before being fed into one of these functions.
 *
 * mat[r][c] = Math.min(mat[r][c], Math.min(bottom, right) + 1);
 *
 * Like setting up the second fn parameter is smart just something you gotta learn.
 */
public class Matrix01_542 {

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] update = updateMatrix(mat);
        print2D(update);
    }

    /**
     * need to get more comfortable with bfs/queues and not just use recursion for every graph problem
     * @param mat
     * @return
     */
    public static int[][] updateMatrix(int[][] mat) {
        int[] DIR = new int[]{0, 1, 0, -1, 0}; // store traversal directions, I kind of like.
        int m = mat.length, n = mat[0].length; // The distance of cells is up to (M+N)
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < m; ++r)
            for (int c = 0; c < n; ++c)
                if (mat[r][c] == 0) q.offer(new int[]{r, c});
        /*
        adds all the nodes that are zeros to the queue starting with the origin
         */
                else mat[r][c] = -1; // Marked as not processed yet!
        /*
        works on the original matrix which I like, if processed, it'll become distance to the 0s
        no curly braces for the loop is fine w/e
         */

        /*
        so up until now only the 0s are in the queue
         */
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            /*
                removes the node at front of container, origin for problem description for example won't have any
                adjacent "unprocessed", so the continue will hit every time.
             */
            int r = curr[0], c = curr[1];
            for (int i = 0; i < 4; ++i) {
                int nr = r + DIR[i], nc = c + DIR[i+1]; // "new" r, "new" c this naming is so bad.
                if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1) continue;
                // if adjacent to a 0, the new ones become 1, next to a 1, 2, etc.
                mat[nr][nc] = mat[r][c] + 1;
                // add the processed node to back of the queue
                q.offer(new int[]{nr, nc});
            }
        }
        return mat;

    }


    /**
     * dynamic programming for the same problem.
     * @param mat
     * @return
     */
    public int[][] updateMatrixDP(int[][] mat) {
        int m = mat.length, n = mat[0].length, INF = m + n; // The distance of cells is up to (M+N)
        /*
        first loop only goes in two directions, top and left.
        Loop starts with origin (0,0) and sweeps right, then goes down a level and does the same
        variables top/left are distances to a zero, set to arbitrarily high values if they fall outside bounds
        Gives an incomplete picture of the distances, e.g. top right which is why you need the second loop.
         */
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 0) continue;
                int top = INF, left = INF;
                if (r - 1 >= 0) top = mat[r - 1][c];
                if (c - 1 >= 0) left = mat[r][c - 1];
                mat[r][c] = Math.min(top, left) + 1;
            }
        }
        /*
        here it is going in the other direction. Starting from bottom right corner, sweeping left, and then up a level
         */
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (mat[r][c] == 0) continue;
                int bottom = INF, right = INF;
                if (r + 1 < m) bottom = mat[r + 1][c];
                if (c + 1 < n) right = mat[r][c + 1];
                mat[r][c] = Math.min(mat[r][c], Math.min(bottom, right) + 1);
                // finally so we're not overwriting an incomplete view of the matrix,
                // there's two min checks, the directional one and the already existing one.
            }
        }
        return mat;
    }

}
