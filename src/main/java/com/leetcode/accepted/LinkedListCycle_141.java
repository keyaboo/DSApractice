package com.leetcode.accepted;

import com.leetcode.utils.ListNode;

import java.util.HashMap;
import java.util.Set;

/**
 * the difficulty is detecting a pattern if the repeating cycle is 2,2,4,4 or something like it
 * the entire time I was thinking about how much easier this would be in C where you can just compare memory
 * addresses directly. I cheated a little here by finding out you could. I don't feel bad because my brute force
 * solution was well-written and I didn't even know you could do this comparison.
 *
 */
public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = new ListNode(0, head);
        ListNode fast = new ListNode(0, head);
        slow = slow.next;
        fast = fast.next;

        while (fast.next != null && slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }


}
