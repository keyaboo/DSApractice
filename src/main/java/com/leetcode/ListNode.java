package com.leetcode;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author christian
 * convenient implementation of listnode object that I found at:
 * https://leetcode.com/problems/delete-node-in-a-linked-list/solutions/654837/listnode-class-implementation-for-java/
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    
    ListNode(int val, ListNode next) {
    	this.val = val;
    	this.next = next;
    }

    public static ListNode createList(int... values) {
        ListNode head = new ListNode(values[0]);
        ListNode prev = head;
        for (int i = 1; i < values.length; i++) {
            prev.next = new ListNode(values[i]);
            prev = prev.next;
        }
        return head;
    }

    public ListNode filter(Predicate<ListNode> f) {

        ListNode node = this;
        while (node != null && !f.test(node)) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {

        return val + "->" + next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}