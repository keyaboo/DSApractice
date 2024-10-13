package com.leetcode.guided.set1;

import java.util.ArrayList;
import java.util.List;

/*
    access previous list with res.get(i-2). If you create a new list at each iteration of the loop,
    where the first element is assigned to 1 no matter what. Hex k is always going to be
    the previous list's k plus the previous list's k - 1. Indexing correctly is somewhat tricky. Loop
    has an upper bound of i - 1 because that's the last row element which always equals 1 if we're beyond
    the first row.
 */
public class PascalsTriangle_118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(0, 1);
            if (!res.isEmpty()) {
                for (int j = 1; j < i - 1; j++) {
                    int sameIdxVal = res.get(i-2).get(j);
                    int previousIdxVal = res.get(i-2).get(j-1);
                    row.add(j, sameIdxVal + previousIdxVal);
                }
                row.add(1); // equivalent: row.add(row.size(), 1);
            }
            res.add(row);
        }
        return res;
    }

}
