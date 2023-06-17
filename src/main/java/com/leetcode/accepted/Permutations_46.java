package com.leetcode.accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * basically adapted the backtracking algo found in subsets. there's a better way to do this though, create a boolean
 * that's passed along as a fn argument that knows whether a given index has already appeared, it will be different
 * for each nest of backtrack just like tempList even though it was only instantiated once. rather than using contains
 * which slows things down, it's a little more elegant.
 */
public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        // Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(res, tempList, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        // this was sloppy, mixing up size w/ correct indices access.
        // if (tempList.size() == nums.length - 1)
        if (tempList.size() == nums.length) {
            // adding arraylist to arraylist, this is how you do it, not res.add(tempList)
            res.add(new ArrayList<>(tempList));
        }
        // targeted cheat here, it seemed wrong to have i = start
        for (int i = 0; i < nums.length; i++) {
            // since this is sorted I feel like there's a reliable way to determine whether a given value has already
            // been selected or not, maybe that's nothing though.
            // ok no the sort had nothing to do with it, the intuition for the contains check was correct, but
            // I needed to stop the loop otherwise the removes below would result in an infinite loop
            boolean containsElementi = tempList.contains(nums[i]); // this shittiness was for investigating inf. loop
            if (containsElementi) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(res, tempList, nums);
            tempList.remove(tempList.size() - 1);
            // be wary of how this could affect the condition for stopping!!
        }
    }

}
