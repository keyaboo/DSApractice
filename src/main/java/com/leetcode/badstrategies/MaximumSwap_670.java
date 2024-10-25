package com.leetcode.badstrategies;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
    this doesn't work whenever you need to switch something other than the leading number.
 */
public class MaximumSwap_670 {
    public int maximumSwap(int num) {
        String numString = String.valueOf(num);
        char[] charArray = numString.toCharArray();
        char lead = charArray[0];
        int swapIdx = 0;
        char swapVal = '0';
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] > charArray[0]) {
                if (swapIdx > 0) {
                    charArray[swapIdx] = swapVal;
                }
                swapIdx = i;
                swapVal = charArray[i];
                charArray[0] = charArray[i];
                charArray[i] = lead;
            }
        }
        String res = new String(charArray);
        return Integer.valueOf(res);
    }
}
