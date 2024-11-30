package com.leetcode.inprogress;

import java.util.HashMap;
import java.util.List;

/*
brute force would be the O(n!) just compare everything. No that would probably be O(n^2) since you'd have
to make everything a candidate res[0] linkedlist or w/e. Could have a hashmap with pair[1], index.
Some sort of backtracking for a bad prospective chain or have a deque where you can add to both ends and
preserve the portion that isn't causing any problems. This could be completely off
 */
public class ValidArrangementPairs_2097 {
    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, List<Integer>> IndexbyStart = new HashMap<>();
        HashMap<Integer, List<Integer>> IndexbyEnd = new HashMap<>();
        return null;
    }
}
