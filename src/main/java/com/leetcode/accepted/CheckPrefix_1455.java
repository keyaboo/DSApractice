package com.leetcode.accepted;

import java.util.ArrayList;
import java.util.List;

/*
separated by single space, wish I knew strtok was in java. Suppose arraylist and reset stringbuilder
whenever sentence has a space in it. the end index for substring I'm pretty sure is inclusive.
Why does this have two loops? space should just reset prefix.

ok the way to do it in java is sentence.split(" ") just fyi
where I messed up was trying to do access the sentence at i + searchIndex, there's no reason to do that
the searchIndex is only for the searchWord.
prefix strategies encountered so far: having previous values stored in a map (like subarray sum eq k)
augmenting the actual value of something later in the array (reviveRakhsh)
and here having a flag for determining whether to evaluate the current value in a regular way or not.
 */
public class CheckPrefix_1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int word = 1;
        int searchIndex = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                searchIndex = 0;
                word++;
            } else if (searchIndex != -1 && sentence.charAt(i) == searchWord.charAt(searchIndex)) {
                    searchIndex++;
                    if (searchIndex == searchWord.length()) return word;
            } else {
                searchIndex = -1; // wait for space to reset
            }

        }
        return -1;
    }

}
