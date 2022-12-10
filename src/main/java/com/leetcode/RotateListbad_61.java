package com.leetcode;
import com.leetcode.ListNode;


/**
 * @author christian
 * second recommended problem for ADM chapter 1
 * I think there are two implementations that could sort of work for this, the one I'll be starting with is the strategy in the graphic
 * but you could do a better job with a solution that simply k % listSize for a new k, shift everything all at once if you know what I mean
 * 
 * not finishing this. going to reattempt knowing what I do now.
 */
public class RotateListbad_61 {
	public static ListNode rotateRight(ListNode head, int k) {
		ListNode newHead = new ListNode(0, head);
		if (k > 0) {
		newHead.next = rotateOnce(head.next);
		}
		for (int i = 0; i < k - 1; i++) {
			newHead.next = rotateOnce(newHead);
		}
		return newHead;

	}
	
	public static ListNode rotateOnce(ListNode head) {
		ListNode curr = new ListNode(0,head);
		curr = curr.next;
		ListNode rootNode = curr;
		int lastVal;
		while (curr.next != null) {
			// this is the trick to stay on penultimate node
			if (curr.next.next == null) {
				lastVal = curr.next.val;
				curr.next = null;
				ListNode n = new ListNode(lastVal,rootNode.next);
				return n;
			} else {
			curr = curr.next;
			}
		}
		
		
		return new ListNode(0);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5};
		ListNode listNode = ListNode.createList(arr);
		ListNode newnode = rotateRight(listNode, 2);
		System.out.println(newnode.next);
		System.out.println();

	}

}
