package com.leetcode.badstrategies;

import com.leetcode.utils.ListNode;

/**
 * fast/slow problem conveniently asking for the second middle in the case of an even # list
 * this is trivial but I kind of hate my answer as well.
 * 
 */
public class MiddleOfLinkedList_876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return slow;
            } else {
                fast = fast.next;
                if (fast == null) {
                    return slow;
                } else if (fast.next == null) {
                    return slow;
                }
            }
        }
        return new ListNode(0);
    }

}
