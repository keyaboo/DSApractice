package com.leetcode.accepted;

import java.util.HashMap;

/*
    rusty, wow.

    parse the string left to right imagining a stack of imbalances for instances of left brace (push, +1).
    if you encounter a right brace (else), this either contributes to the imbalance if there weren't any (push, +1)
    or offsets a known imbalance (pop, -1).
    Not immediately obvious is that 1 swap corrects the imbalance on 4 different characters, or 2 [] pairs.
    For this reason, you divide by 2
 */
public class MinimumBalancedSwaps_1963 {
    public int minSwaps(String s) {
        int imbalance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') { // imagine a whole lot of '['s at EOS
                imbalance++;
            } else {
                if (imbalance > 0) {
                    imbalance--;
                } else if (imbalance == 0) {
                    imbalance++;
                }
            }
        }
        return (imbalance / 2);
    }

}


