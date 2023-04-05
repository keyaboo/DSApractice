package com.leetcode.badstrategies;

import java.util.*;

/**
 * I have no idea why this wasn't accepted. I don't see any character repeating more than twice for this test case string
 * but apparently 4 is the fewest # of substrings.
 *
 * what I didn't realize was that the substring partitions have to be contiguous substrings of the original. The hashset
 * and arraylist of hashsets was smart but the record-keeping of the map wasn't good.
 *
 */
public class OptimalStringPartitionmisunderstood_2405 {
    public static void main(String[] args) {
        String s = "hdklqkcssgxlvehva";
        System.out.println(partitionString(s));

    }

    public static int partitionString(String s) {
        List<Set<Character>> uniqueStrings = new ArrayList<Set<Character>>();
        HashMap<Character, Integer> mostRecentIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            createSubstrings(s.charAt(i), uniqueStrings, mostRecentIndex);
        }
        System.out.println("debug");
        return uniqueStrings.size();
    }

    public static void createSubstrings(Character c, List<Set<Character>> uniqueStrings, HashMap<Character, Integer> mostRecentIndex) {
        if (uniqueStrings.size() == 0) {
            HashSet<Character> newSet = new HashSet<>();
            newSet.add(c);
            uniqueStrings.add(newSet); // this is what I had forgotten to do
            mostRecentIndex.put(c,0);
        } else {
            if (mostRecentIndex.containsKey(c)) {
                if (mostRecentIndex.get(c) < uniqueStrings.size() - 1) {
                    uniqueStrings.get(mostRecentIndex.get(c) + 1).add(c);
                    mostRecentIndex.put(c, mostRecentIndex.get(c) + 1);
                } else {
                    HashSet<Character> newSet = new HashSet<>();
                    newSet.add(c);
                    uniqueStrings.add(newSet);
                    mostRecentIndex.put(c,mostRecentIndex.get(c)+1);
                }
            } else {
                mostRecentIndex.put(c,0);
                uniqueStrings.get(0).add(c);
                // don't have to reassign highest since it's already set to minimum above
            }
        }
    }


}

