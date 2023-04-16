package com.leetcode.accepted;

import java.util.Random;

/**
 * learning new kinds of loops that I wouldn't have thought to approach problems with, that's why it's worth
 * doing the same problem 3 times if necessary.
 */
public class FirstBadVersion_278 {
    public boolean isBadVersion(int version) {
        Random random = new Random();
        return random.nextBoolean();
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int midPoint = start + (end - start)/2;
            if (!(isBadVersion(midPoint))) {
                start = midPoint + 1;
            } else {
                end = midPoint;
            }
        }
        return start;
    }
}
