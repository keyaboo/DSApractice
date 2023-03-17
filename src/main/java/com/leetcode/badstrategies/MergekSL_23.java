package com.leetcode.badstrategies;

import com.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * this is not a great way of doing it but it's technically correct.
 * Lesson here among many, never do a nullcheck on node.val, always just do it on node first
 */
public class MergekSL_23 {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{ListNode.createList(1,4,5), ListNode.createList(1,3,4), ListNode.createList(2,6)};
        ListNode answer = mergeKlists(lists);
        System.out.println(answer);
    }

    public static ListNode mergeKlists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode tail = new ListNode(0,head);
        tail = tail.next;
        ArrayList<Integer> vals = new ArrayList<Integer>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                vals.add(lists[i].val);
            } else {
                vals.add(null);
            }
        }
        while (getSmallestIndex(vals) != -1) {
            int indexSmallest = getSmallestIndex(vals);
            ListNode smallest = new ListNode(vals.get(indexSmallest));
            tail.next = smallest;
            tail = tail.next;
            System.out.println(lists[indexSmallest].val);
            lists[indexSmallest] = lists[indexSmallest].next;
            if (lists[indexSmallest] != null) {
                vals.set(indexSmallest, lists[indexSmallest].val);
            } else {
                vals.set(indexSmallest, null);
            }
        }
        return head.next;
    }

    public static int getSmallestIndex(List<Integer> arr) {
        Integer smallest = null;
        int indexSmallest = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != null) {
                Integer num = arr.get(i); // System.out.println(num);
                if (smallest == null) {
                    smallest = num;
                    System.out.println();
                    indexSmallest = i;
                } else if (num <= smallest) {
                    smallest = num;
                    indexSmallest = i;

                }
            }
        }
        return indexSmallest;
    }


}
