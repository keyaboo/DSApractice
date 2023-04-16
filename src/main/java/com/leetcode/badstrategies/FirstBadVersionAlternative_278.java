package com.leetcode.badstrategies;

import java.util.Random;

/**
 * redo this one using a normal while loop for the binary search rather than recursion.
 *
 * interesting little tidbit about setting mid correctly.
 * https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
 *
 * I think the temptation is to
 */
public class FirstBadVersionAlternative_278 {

    public boolean isBadVersion(int version) {
        Random random = new Random();
        return random.nextBoolean();
    }
    // okay so this was redone but it's still awful.
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int midPoint = getMidpoint(start, end);
        while (midPoint >= 1 && midPoint <= n) {
            if (isBadVersion(midPoint)) {
                if (!isBadVersion(midPoint-1) || midPoint == 1) {
                    return midPoint;
                }
                end = midPoint;
                midPoint = getMidpoint(start, end);
            } else {
                if (midPoint == n - 1) {
                    return n;
                }
                start = midPoint;
                midPoint = getMidpoint(start, end);
            }
        }
        return midPoint;
    }

    public static int getMidpoint(int start, int end) {
        return (start + (end - start)/2);
    }
}
