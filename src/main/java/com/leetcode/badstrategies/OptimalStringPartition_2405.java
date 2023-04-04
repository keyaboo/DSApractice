package com.leetcode.badstrategies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * my thinking would be to have a vector/arraylist of hashets. each letter cycles through the hashsets and checks
 * whether or not it's already present, if not a new one is created, if is it'll be added to that set. The return
 * value could just be the size() of the arraylist.
 */
public class OptimalStringPartition_2405 {
    public static void main(String[] args) {
        String s = "abacaba";
        System.out.println(partitionString(s));
    }

    public static int partitionString(String s) {
        ArrayList<Set<Character>> uniqueSets = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            addToSet(uniqueSets,c);
        }

        System.out.println("debug");
        return uniqueSets.size();
    }
    public static void addToSet(ArrayList<Set<Character>> uniqueSets, Character c) {
        if (uniqueSets.isEmpty()) {
            Set<Character> newSet = new HashSet();
            newSet.add(c);
            uniqueSets.add(newSet);
        } else {
            for (int i = 0; i < uniqueSets.size(); i++) {
                if (!(uniqueSets.get(i).contains(c))) {
                    uniqueSets.get(i).add(c);
                } else if (!(uniqueSets.get(i).contains(c)) && i == (uniqueSets.size() - 1)) {
                    Set<Character> newSet = new HashSet<>();
                    newSet.add(c);
                    uniqueSets.add(newSet);
                }
            }
        }

    }


}
