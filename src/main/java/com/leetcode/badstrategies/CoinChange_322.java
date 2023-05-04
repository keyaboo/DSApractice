package com.leetcode.badstrategies;

import java.util.HashMap;

/**
 * there was something like this early on in SICP and it used recursion.
 * create a hashmap of integer amount, integer steps.
 * create a new array of coinsubtractions -> [11 - 1, 11 -2, 11- 5]
 * add all vals of coinsubtractions to hashmap with the # of steps so far required in order to reach that.
 * if the value already exists -> 11 - 2 - 2 - 2 (3 steps) > existing 11 - 5 - 1, you don't overwrite
 * eventually you can check the hashmap for vals 1, 2, and 5.
 * if none of these happen to exist, return -1;
 *
 * check whether coinsubtraction vals are > 0.
 *
 * time limit exceeded with this. gonna see what I did wrong here
 */
public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        HashMap<Integer, Integer> diffBySteps = new HashMap<>();
        diffBySteps.put(amount, 0);
        furtherReduce(coins, amount, diffBySteps);
        return (diffBySteps.containsKey(0)) ? diffBySteps.get(0) : -1;
    }

    public void furtherReduce(int[] coins, int amount, HashMap<Integer, Integer> diffBySteps) {
        int[] differences = new int[coins.length];
        int steps = diffBySteps.get(amount);
        for (int i = 0; i < coins.length; i++) {
            differences[i] = amount - coins[i];
            if (differences[i] >= 0 && !diffBySteps.containsKey(differences[i])) {
                diffBySteps.put(differences[i], steps + 1);
            } else if (differences[i] >= 0) {
                int existing = diffBySteps.get(differences[i]);
                diffBySteps.put(differences[i], Math.min(existing, steps+1));
            }
        }
        for (int i = 0; i < differences.length; i++) {
            if (differences[i] > 0)
                furtherReduce(coins, differences[i], diffBySteps);
        }
    }


}
