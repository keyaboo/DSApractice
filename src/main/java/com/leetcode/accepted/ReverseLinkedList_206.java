package com.leetcode.accepted;

import com.leetcode.utils.ListNode;

import java.util.Stack;

/**
 * ok, the trick with this one is reassigning the original head list within the while loop for a O(1)
 * memory score. the first time I've ever seen that.
 *
 */
public class ReverseLinkedList_206 {
    /**
     * brute force solution
     */
    public ListNode reverseList(ListNode head) {
        Stack<Integer> valsStack = new Stack<>();
        while (head != null) {
            valsStack.push(head.val);
            head = head.next;
        }
        ListNode reverse = new ListNode(0);
        ListNode temp = reverse;
        while (!valsStack.isEmpty()) {
            temp.next = new ListNode(valsStack.pop());
            temp = temp.next;
        }
        return reverse.next;
    }

    /**
     * list: 1, 2, 3, null; prev : null
     * remaining sequence: 2, 3, null; intermediate head/prev: 1, (null), final head: 2, 3, null
     * remaining sequence: 3, null; intermediate head/ prev: 2, (1, null), final head: 3, null
     * remaining sequence: null; intermediate head: 3, (2, 1, null); final head: null
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode remainingSequence = head.next;
            head.next = prev;
            prev = head;
            head = remainingSequence;
        }
        return prev;
    }

}
