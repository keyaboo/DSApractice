package com.leetcode.badstrategies;

import com.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * so this is a recommended problem in ADM chapter 3 except they refer to the hackerrank one. Does not seem that easy
 * 3 -> -2 -> 0 -> 4 -> 2 -> 0 ->
 *
 * // thinking about summing all the values but switching the signs every time, even if the cycle is odd you'd find
 * out about it at the 2x mark (evidence of a 3 cycle would appear as though it were a 6 cycle)
 * 3 -> 2 -> 0 -> -4 -> 2 -> 0 -> -4 -> 2 -> 0 -> -4
 * 5 -> 5 -> 1 -> 3 -> 3 -> -1 -> 1 -> 1 > -3
 * 10 -> 11 -> 14 -> 17 -> 16 -> 17
 * 21 -> 34 -> 51 -> 68 -> 85
 * 55 -> 106 -> 174 -> 259
 * 4 -> 2 ->
 */
public class LinkedListCycle_141 {
    public static void main(String[] args) {
    }
// brute force approach, failed because memory limit exceeded but it worked on the simple test cases. Maybe this can
    // be done with fast and slow pointers.
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        } else {
            List<Integer> repeats = new ArrayList<Integer>();
            Set<Integer> seenPrevious = new HashSet<Integer>();
            seenPrevious.add(head.val);
            while (head != null) {
                head = head.next;
                if (head == null) {
                    return false;
                } else {
                    if (!(seenPrevious.contains(head.val))) {
                        seenPrevious.add(head.val);
                        repeats = new ArrayList<>();
                    } else {
                        repeats.add(head.val);
                        int repeatsHalfLength = (repeats.size()) / 2;
                        for (int i = 0; i < repeatsHalfLength; i++) {
                            if (repeats.get(i) != repeats.get(i + repeatsHalfLength)) {
                                break;
                            } else if (i == repeatsHalfLength - 1 && (repeats.get(i) == repeats.get(i + repeatsHalfLength))) {
                                return true;
                            }
                        }
                    }

                }
            }
            return false;
        }

    }
}
