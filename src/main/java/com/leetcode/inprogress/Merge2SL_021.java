package com.leetcode.inprogress;
import com.leetcode.utils.ListNode;

/**
 * what I sort of figured out 
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
        while ((list1 != null) || (list2 != null)) {
            int list1val = list1.val; System.out.println("list1val=" + list1val);
            int list2val = list2.val; System.out.println("list2val=" + list2val);
            if (list1val < list2val || list1val == list2val) {
                curr.next = new ListNode(list1.val);
                curr = curr.next;
                list1 = list1.next;
            } else if (list1val > list2val) {
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


}
