package com.leetcode.inprogress;

import com.leetcode.utils.ListNode;

/**
 * @author christian
 * 
 */
public class SwapNodesinPairs_24 {

	public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        ListNode list = ListNode.createList(arr);
        ListNode newList = swapPairs(list);
        for (int i = 0; i < arr.length; i++) {
        	System.out.println(newList.val);
        	newList = newList.next;
        }
        
	}
	
    public static ListNode swapPairs(ListNode head) {
    	if (head.next == null) {
    		return head;
    	} else if (head.next == null) {
    		return head;
    	} else if (head.next.next != null) {
    		ListNode dummyHead = new ListNode(0); // instantiate a new head
    		dummyHead.next = head; // alternate constructor isn't available in this implementation so 
    		ListNode curr = dummyHead.next; // current node is the next of the initialization node, dummyHead.next is also what gets returned at the end.
    		while (curr.next != null) {
        		ListNode secondNode = curr.next;
        		ListNode tail = curr.next.next; 
    			ListNode temp = curr;
    			temp.next = tail;
    			secondNode.next = temp;
    			curr = secondNode.next.next;
    		}
    		return dummyHead.next;
    	}
    	
    	return new ListNode(0);
    }

}

