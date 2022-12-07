package com.leetcode;

import java.util.Hashtable;

public class AddTwoNumbers {

	public static void main(String[] args) throws CloneNotSupportedException {
		AddTwoNumbers n = new AddTwoNumbers();
		ListNode l1 = n.new ListNode();
		l1 = n.new ListNode(4,l1);
		l1 = n.new ListNode(5,l1);
		l1 = n.new ListNode(7,l1);
		ListNode l2 = (ListNode) l1.clone();
		
        int l1size = getNSize(l1);
        ListNode l3 = n.reverseListNode(l2, l1size);
        
		ListNode l4 = n.new ListNode();
		l4 = n.new ListNode(3,l1);
		l4 = n.new ListNode(1,l1);
		l4 = n.new ListNode(7,l1);
		
		ListNode l5 = (ListNode) l4.clone();
		int l4size = getNSize(l4);
		ListNode l6 = n.reverseListNode(l5, l4size);
		ListNode l7 = n.addListNodes(l6, l3);
        
	}
	
	private static ListNode addListNodes(ListNode l1, ListNode l2) {
		AddTwoNumbers n = new AddTwoNumbers();
		ListNode listNode = n.new ListNode();
		boolean carry = false;
		int carryval = (carry) ? 1 : 0;
		for (int i = 0; i <= 100; i++) {
			if (l1.next != null || l2.next != null) {
				int sum = l1.val + l2.val + carryval;
				carry = (sum >= 10) ? true : false;
				sum = (carry) ? sum - 10 : sum;
				listNode = n.new ListNode(sum, listNode);
				System.out.println(listNode.val);
				l1 = (l1.next != null) ? l1.next : l1;
				l2 = (l2.next != null) ? l2.next : l2;		
			} else if (l1.next == null && l2.next == null && carry) {
				listNode = n.new ListNode(carryval, listNode);
			}
		}
		return listNode;
		
	}
	
    private static int getNSize(ListNode listNode) {
        int counter = 0;
        for (int i = 0; i < 100; i++) {
            if (listNode.next != null) {
            	listNode = listNode.next;
                counter++;
            }
        }
        return counter;
    }
    
    private static ListNode reverseListNode(ListNode listNode, int count) {
		AddTwoNumbers n = new AddTwoNumbers();
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
    	for (int j = 0; j < count; j++) {
    		Integer value = listNode.val;
    		listNode = listNode.next;
    		System.out.println("j=" + j + " value=" + value);
    		ht.put(j, value);
    	}
    	ListNode reverse = n.new ListNode();
    	for (int k = count-1; k >= 0; k--) {
    		int kth = ht.get(k);
    		System.out.println("kth=" + kth + " k=" + k);
    		reverse = n.new ListNode(kth,reverse);
    	}
    	return reverse;
    }
    
    private class ListNode implements Cloneable {
    	 int val;
    	 ListNode next;
    	 public ListNode() {}
    	 public ListNode(int val) { this.val = val; }
    	 public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    	 public Object clone() throws CloneNotSupportedException
    	    {
    	        return super.clone();
    	    }
    	 }


}
