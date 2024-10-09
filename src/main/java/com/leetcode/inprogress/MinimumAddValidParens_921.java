package com.leetcode.inprogress;

/*
    this is very similar to 1963 minimum balanced swaps.
    have counters for left and right imbalances. increment lb imbalance and rb imbalance as '(' and ')' appear.
    these characters by default suggests an 'add brace' for the complement should occur.
    But when seeing a RB and the current count of LB is not 0, the present RB is offsetting an imbalanced
    LB, so decrement both imbalance counts. -> we don't want to increment because the pair could be
    part of an already valid A or an A that would be valid with (LB + RB) corrections.
 */
public class MinimumAddValidParens_921 {
    public int minAddToMakeValid(String s) {
        int LB = 0;
        int RB = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                LB++;
            } else if (s.charAt(i) == ')') {
                RB++;
                if (LB > 0) {
                    LB--;
                    RB--;
                }
            }
        }
        return LB + RB;
    }

}
