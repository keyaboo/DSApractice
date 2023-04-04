package com.leetcode.inprogress;

import java.util.*;

public class OptimalStringPartition_2405 {
    public static void main(String[] args) {
        String s = "ssssss";
        System.out.println(partitionString(s));

    }

    public static int partitionString(String s) {
        List<Set<Character>> uniqueStrings = new ArrayList<Set<Character>>();
        HashMap<Character, Integer> mostRecentIndex = new HashMap<>();
        Integer highest = null;
        for (int i = 0; i < s.length(); i++) {

        }
        return 0;
    }

    public static void createSubstrings(Character c, List<Set<Character>> uniqueStrings, HashMap<Character, Integer> mostRecentIndex, Integer highest) {
        if (uniqueStrings.isEmpty()) {
            HashSet<Character> newSet = new HashSet<>();
            newSet.add(c);
            mostRecentIndex.put(c,0);
            highest = 0;
        } else {
            if (mostRecentIndex.containsKey(c)) {
                if (mostRecentIndex.get(c) < highest) {
                    //
                }
            }
        }
    }


}

