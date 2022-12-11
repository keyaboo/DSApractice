package com.leetcode;

/**
 * @author christian
 * ok nice this got accepted as an O(n) and is supposedly the fastest solution you can hope for !!!
 */
public class RotateList_61 {

	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5};

		ListNode listNode = ListNode.createList(arr);
		ListNode ln = rotateRight(listNode, 2);
		System.out.println(ln);
	}
	
	public static int countNodes(ListNode listNode) {
		ListNode dummyHead = new ListNode(0, listNode);
		int counter = 0;
		while (dummyHead.next != null) {
			counter++;
			dummyHead = dummyHead.next;
		}
		return counter;
	}
	
	public static ListNode rotateRight(ListNode listNode, int k) {

		if (listNode == null) { // dumb edge case bullshit
			return null;
		} 
		
		int nodes = countNodes(listNode);
		int shifts = k % nodes;

		if (listNode.next == null || shifts == 0) {
			return listNode;
		}
		
		// System.out.println("shifts=" + shifts);
		// System.out.println("nodes=" + nodes);
		ListNode dummyHead = new ListNode(0,listNode);
		ListNode curr = dummyHead.next;
		int counter = 0;
		// System.out.println("nodes - shifts=" + (nodes - shifts));
		ListNode tail = new ListNode(0);
		while (counter < (nodes - shifts)) {
			counter++;
			if (counter == (nodes - shifts)) {
				tail.next = curr.next;
				curr.next = null;
			} else {
			curr = curr.next;
			}
		}
		// System.out.println("dummyHead=" + dummyHead);
		ListNode tailStart = new ListNode(0,tail); 
		while (tail.next != null) {
			tail = tail.next;
			// System.out.println("tail=" + tail.val);

			if (tail.next == null) {
				tail.next = dummyHead.next;
				return tailStart.next.next;
				/* it's tail.next.next because tail was initialized with the 0 and so was tailstart
				 * gonna see how the solution is actually implemented. */
			}
		}
		return new ListNode(0);
	}
	

}
