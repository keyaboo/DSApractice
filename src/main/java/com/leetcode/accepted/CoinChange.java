package com.leetcode.accepted;

import java.util.Arrays;

/**
 * rather than a hashmap, just using an array
 * and rather than starting from the top (amount) and subtracting, start from 0, initialize subsequent values
 * to integer.max_value, and then loop over each of the coins, starting with the smallest. so a sort of coins
 * needs to happen first.
 *
 * I think what's important to remember for dynamic programming, whether fibonacci, fewest steps, or this
 * is that it always starts from the bottom.
 *
 * ok I fucked up integer overflow. be very careful when selecting your arbitrarily large numbers because
 * 1 + Integer.MAX_VALUE continues to be a problem :(
 *
 * the important thing to do is review all of these different approaches. will do weekend of May 5, 2023
 * if I do not do so send an email to chris.ramsland@gmail.com and call me a lazy fuck.
 *
 * https://leetcode.com/problems/coin-change/solutions/77409/evolve-from-brute-force-to-optimal-a-review-of-all-solutions/?orderBy=most_votes&languageTags=java
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] steps = new int[amount + 1]; // amount is inclusive.
        steps[0] = 0; // key initialization for the step counting.
        for (int i = 1; i < steps.length; i++) {
            steps[i] = amount + 1;
            for (int coin:coins) {
                if (i - coin < 0) {
                    break;
                }
                int current = steps[i];
                steps[i] = Math.min(steps[i], 1 + steps[i - coin]);
            }
        }
        return (steps[amount] > amount) ? -1 : steps[amount];
    }

}
