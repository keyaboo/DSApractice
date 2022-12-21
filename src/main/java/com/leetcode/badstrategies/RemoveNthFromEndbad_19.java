package com.leetcode.badstrategies;

import com.leetcode.ListNode;

/**
 * @author christian
 * bad way of doing this. it seems the best way to do it is with two passes, with (not one but) n+1 node(s) in between the two.
 * Don't use a while loop with the .next nullchecks, use a for loop to move the faster one n spaces ahead at the start.
 * THEN use fast's nullcheck in a while loop to move both fast and slow forward incrementally.
 * 
 */
public class RemoveNthFromEndbad_19 {

	public static void main(String[] args) {
		ListNode ln = ListNode.createList(1,2);
		int n = 2;
		ListNode returned = removeNthFromEnd(ln, n);
		System.out.println(returned);
	}
	
	public static int countNodes(ListNode head) {
		int counter = 1;
		while (head.next != null) {
			counter++;
			head = head.next;
		}
		return counter;
	}
	
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null) {
    		return null;
    	}
    	if (head.next == null && n == 1) {
    		return null;
    	}
    	int nodeCount = countNodes(head);
    	// if the count's being done correctly should be the same as all appearing numbers, start at 1 and determine with nullcheck on next
    	System.out.println(nodeCount);

    	int stop = nodeCount - n;
    	
    	ListNode dummyHead = new ListNode(0,head);
    	if (stop == 0) {
    		return dummyHead.next.next;
    	}
    	ListNode curr = dummyHead.next;
    	int counter = 0;
    	while (counter < stop) {
    		counter++;
    		if (counter == stop) {
    			ListNode temp = curr.next.next;
    			curr.next = temp;
    		}
    		curr = curr.next;
    	}
    	return dummyHead.next;
    }

}
