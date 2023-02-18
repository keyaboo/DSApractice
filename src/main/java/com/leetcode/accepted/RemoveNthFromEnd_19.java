package com.leetcode.accepted;

import com.leetcode.utils.ListNode;

/**
 * not the fastest solution, but I got it correct. I think it can be done in truly O(n) time
 */
public class RemoveNthFromEnd_19 {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */

	public static void main(String[] args) {
		ListNode ln = ListNode.createList(1,2,3,4,5);
		int n = 0;
		// testing edge cases: n = 0, n = 5
		// got an n = 0 fail, solved it by checking doing a null check of lag.next.next
		// anticipate n=5 failing: second loop probably wouldn't execute at all the way I have it written?
		// goal is to splice off 1: success
		ListNode returned = removeNthFromEnd(ln, n);
		System.out.println(returned);

	}

	public static ListNode removeNthFromEnd(ListNode head, int n){
		// forgot about edge case of empty list
		if (head == null) {
			return null;
		}
		ListNode lead = new ListNode(0,head);
		// first debug the counter since it's returning 1->3->4->5->null, lead should be left on 2

		// n=5 this I wanted to introduce down lower before the second loop, but since I can catch the n=length(list)
		// edge case in this loop, might as well introduce the other variables here earlier
		ListNode lag = new ListNode(0,head);
		ListNode dummyHead = lag;

		int counter = 0;
		while(lead.next != null && (counter < n)){
			lead = lead.next;
			counter++;
			// n = 5
			if (lead.next == null) {
				lag.next = lag.next.next;
			}

		}
		// ok it seems to be that's good, I tried messing with counter <= n and that made the problem worse
		System.out.println("lead val =" + lead.val + " counter = " + counter);

		while(lead.next != null && (lag.next.next != null)){
			lead = lead.next;
			lag = lag.next;
			if (lead.next == null) {
				lag.next = lag.next.next;
			}

		}
		return dummyHead.next;
	}

}
