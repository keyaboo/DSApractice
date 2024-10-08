package com.leetcode.inprogress;

import java.util.HashMap;

public class MinimumBalancedSwaps_1963 {
    public int minSwapsShitty(String s) {
        int[] leftBraceCount = new int[s.length()];
        int[] rightBraceCount = new int[s.length()];
        int leftBraceInc = 0;
        int rightBraceInc = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                leftBraceInc++;
            } else if (s.charAt(i) == ']') {
                rightBraceInc++;
            }
            leftBraceCount[i] = leftBraceInc;
            rightBraceCount[i] = rightBraceInc;
        }
        int leftBraceDec = 0;
        int rightBraceDec = 0;
        int res = 0;
        return 0;
    }

    public int minSwaps(String s) {
        int stackSize = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stackSize++;
            } else {
                if (stackSize > 0) {
                    stackSize--;
                } else if (stackSize == 0) {
                    stackSize++;
                }
            }
        }
        return (stackSize / 2);
    }

}


/*
    rusty, wow.
    thought: could this 2 pointer where the "[" comes from the end of the string? No, example 2
    create 2 arrays where count of cumulative quantity of "[" or "]" is indexed by value.
    looked at second hint: reminds me there's no actual swapping being done here.
    compare indices of the two arrays, if LB[index] < RB[index]


    no, terrible. real solution:

    parse the string left to right imagining a stack for instances of left brace.
    if you encounter a right brace (else), you have a corresponding RB for the LB on the stack, so pop it for fewer imbalances to worry about.
    but if the stack is empty, put this info into the stack.
    Not immediately obvious is that 1 swap corrects the imbalance on 4 different characters, or 2 [] pairs.
    For this reason, and because you can have strings of odd length, you divide by 2
 */