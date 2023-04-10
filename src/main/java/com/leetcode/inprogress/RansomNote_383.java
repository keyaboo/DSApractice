package com.leetcode.inprogress;

/**
 * hashmap<char,int count> to create a magazine character dictionary. do containskey checks on each string
 * in the ransomnote, do the get to ensure > 0, decrement the value in the HT for every string appearing in RN
 *
 * since I'm doing notes here and the next appearing on the list is climbing stairs which I've already done,
 * might as well outline that one's strategy.
 * create hashmap memo for DP: <steps, int combos the return for steps>
 * write recursive function that checks whether steps param = 0 return 0, steps - 1 = 0 return 1,
 * steps - 1 > 0 return fn(steps - 1), ditto for -2, and steps - 2 == 0 return 1, the hashmap is brought along
 * for every function call and written to.
 */
public class RansomNote_383 {
}
