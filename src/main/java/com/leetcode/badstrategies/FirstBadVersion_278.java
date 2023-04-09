package com.leetcode.badstrategies;

import java.util.Stack;

/**
 * this is pretty much the same thing as a binary search
 * well implementing it that way is possible but apparently not very performative.
 */
public class FirstBadVersion_278 {

    public static boolean isBadVersion(int version){ return false; }

    public static int firstBadVersion(int n) {
        if (isBadVersion(n) == true && isBadVersion(n-1) == false || n == 1 && isBadVersion(n) == true ) {
            return n;
        } else {
            return binarySearch(1, n);
        }
    }

    public static int binarySearch(int start, int end) {
        int midPoint = start + ((end - start) / 2);
        if (isBadVersion(midPoint) == true && isBadVersion(midPoint-1) == false) {
            return midPoint;
        } else if (isBadVersion(midPoint) == false) {
            midPoint = binarySearch(midPoint, end);
        } else if (isBadVersion(midPoint) == true) {
            midPoint = binarySearch(start, midPoint);
        }
        return midPoint;
    }
}
