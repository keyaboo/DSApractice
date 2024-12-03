package com.leetcode.inprogress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/*
brute force would be the O(n!) just compare everything. No that would probably be O(n^2) since you'd have
to make everything a candidate res[0] linkedlist or w/e. Could have a hashmap with pair[1], index.
Some sort of backtracking for a bad prospective chain or have a deque where you can add to both ends and
preserve the portion that isn't causing any problems. This could be completely off.
 */
public class ValidArrangementPairs_2097 {
    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, List<Integer>> indexbyStart = new HashMap<>();
        HashMap<Integer, List<Integer>> indexbyEnd = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            int[] pair = pairs[i];
            indexbyStart.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(i);
            indexbyEnd.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(i);
        }
        ArrayList<Integer> startingCandidates = new ArrayList<>();
        for (int key : indexbyStart.keySet()) {
            if (indexbyStart.get(key).size() != indexbyStart.get(key).size()) {
                startingCandidates.addAll(indexbyStart.get(key));
                break;
            }
        }
        int[][] res = new int[pairs.length][];
        return res;
    }
}
