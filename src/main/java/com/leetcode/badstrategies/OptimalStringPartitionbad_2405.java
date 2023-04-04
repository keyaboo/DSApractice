package com.leetcode.badstrategies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * rewriting because I got it wrong, seemed pretty easy but there was some sloppiness and I want to get out of the
 * habit of changing one thing
 * time limit exceeded - what I did here sucks. I will re-try where I retain the vector of hashsets, but instead
 * of looping over them, I can have a hashtable store the index of the hashset in the array with the most recent
 * addition to get pure O(n). Not messing with bit manipulation stuff.
 */
public class OptimalStringPartitionbad_2405 {
    public static void main(String[] args) {
        String s = "qssssss";
        System.out.println(partitionString(s));

    }

    public static int partitionString(String s) {
        List<Set<Character>> uniqueSubstrings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            addCharacters(uniqueSubstrings,c);
        }
        return uniqueSubstrings.size();
    }

    public static void addCharacters(List<Set<Character>> uniqueSubstrings, Character c) {
        if (uniqueSubstrings.isEmpty()) {
            HashSet<Character> firstSet = new HashSet<>();
            firstSet.add(c);
            uniqueSubstrings.add(firstSet);
        } else {
            for (int i = 0; i < uniqueSubstrings.size(); i++) { // this approach is awful doing so many unnecessary checks
                if (!(uniqueSubstrings.get(i).contains(c))) {
                    uniqueSubstrings.get(i).add(c);
                } else if (uniqueSubstrings.get(i).contains(c) && i == (uniqueSubstrings.size() - 1)) {
                    HashSet<Character> newSet = new HashSet<>(c);
                    uniqueSubstrings.add(newSet);
                }
            }
        }
    }
}
