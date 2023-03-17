package com.leetcode.accepted;
import com.leetcode.utils.ListNode;

/**
 * account for possibility of either list being null from the beginning***
 */
public class Merge2SL_021 {
    public static void main(String[] args){
        ListNode l1 = ListNode.createList(1,2,4);
        ListNode l2 = ListNode.createList(1,3,4);
        ListNode l3 = mergeTwoLists(l1, l2);
        System.out.println(l3);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode curr = new ListNode(0, head);
        curr = curr.next;
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        while ((list1 != null) || (list2 != null)) {
            if (list1.val < list2.val || list1.val == list2.val) { // stupid: don't check for vals as null check for listnodes themselves
                curr.next = new ListNode(list1.val);
                curr = curr.next;
                list1 = list1.next;
            } else if (list1.val > list2.val) {
                curr.next = new ListNode(list2.val);
                curr = curr.next;
                list2 = list2.next;

            }
            // omg this is clever
            if (list1 == null) {
                curr.next = list2;
                return head.next;
            } else if (list2 == null) {
                curr.next = list1;
                return head.next;
            }

        }
        return head.next;
    }

    // very cool recursive solution I found
        public static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
            if(list1 == null) {
                return list2;
            }
            if(list2 == null) {
                return list1;
            }
            ListNode list3 = new ListNode();

            if(list1.val < list2.val) {
                list3 = list1;
                list3.next = mergeTwoListsRecursive(list1.next, list2);
            }
            else {
                list3 = list2;
                list3.next = mergeTwoListsRecursive(list1, list2.next);
            }
            return list3;
        }

}
