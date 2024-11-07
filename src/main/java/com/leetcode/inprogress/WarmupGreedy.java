package com.leetcode.inprogress;

import java.util.*;

public class WarmupGreedy {
    // don't confuse that s and g are necessarily aligned because all the examples seem to imply.
    // s = [1 5 6] g = [4 5 6] has 2 content children so it's a 2 pointer problem
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int i = 0;
        int j = 0;
        while (j < g.length && i < s.length) {
            if (s[i] >= g[j]) {
                count++;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return count;
    }

    // GFG fractional knapsack: diamond necklace value high weight low, clay brick value low weight high
    /*
    Even though this is more interesting as a dp problem I want to do the greedy approach first.
    Nevermind the ratios are doubles so the array of int triplets wasn't going to work.

    This is a 2D table approach like in the neetcode guys videos.
    each cell of dp[i][w] will store the maximum total value that can be achieved using items up to index i - 1
    first loop iterates over each item, the rows of the dp table.
    i = 0 is base case where we consider no items yet, w = 0 is a knapsack with 0 capacity

    illustrative example: int[] values = {10, 20, 30}; int[] weights = {5, 10, 15}; int capacity = 20;

         0   1   2   3   ...  20 (capacity)
  +-----------------------
0 |  0   0   0   0   ...   0
  |
1 |  0   ?   ?   ?   ...   ?  (Item 1)
  |
2 |  0   ?   ?   ?   ...   ?  (Item 2)
  |
3 |  0   ?   ?   ?   ...   ?  (Item 3)

full dp table:
     0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19  20
  +----------------------------------------------------------------------------------
0 |  0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0
  |
1 |  0   0   0   0   0  10  10  10  10  10  10  10  10  10  10  10  10  10  10  10  10
  |
2 |  0   0   0   0   0 *10* 10  10  10  10  20  20  20  20  20  20  20  20  20  20  20
  |
3 |  0   0   0   0   0  10  10  10  10  10  20  20  20  20  20  30  30  30  30  30  40

grid position 3,20 is looking at dp[2][5]

     */

    // nvm this is completely wrong for fractional knapsack, this is for discrete knapsack.
    int zeroOneKnapsack(List<Integer> values, List<Integer> weights, int capacity) {
        int n = values.size();
        int[][] dp = new int[n+1][capacity + 1]; // ok rows are all the values that can be taken or skipped.
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) { // base case and prevents any scenario where you'd be looking left out of bounds
                    dp[i][w] = 0; //
                } else if (weights.get(i-1) <= w) { // is the item's weight greater than current knapsack capacity
                    dp[i][w] = Math.max(
                      values.get(i - 1) + dp[i - 1][w - weights.get(i - 1)], // include the item, taking its value
                            // w - weights.get(i - 1) calculates the remaining capacity in knapsack after including current item.
                        dp[i - 1][w] // don't include item, the capacity remains the same. a more valuable item has
                    );
                } else { // the item doesn't fit. The maximum value is the same as the max value achievable with the
                    // remaining items and the same capacity.
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    // heap-based approach
    /*
    from open chairs problem the idea of storing a
     */
    double fractionalKnapsackHeap(List<Integer> values, List<Integer> weights, int W) {
        int n = values.size();
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(Comparator.comparingDouble(a -> -a[0]));
        for (int i = 0; i < n; i++) {
            double[] item = new double[] {((1D * values.get(i)) / (1D * weights.get(i))), (double) i};
            maxHeap.offer(item);
        }
        double totalVal = 0D;
        while (!maxHeap.isEmpty() && W > 0) {
            double[] item = maxHeap.poll();
            int index = (int) item[1];
            double fraction = Math.min(1.0, (double) W / weights.get(index));
            totalVal += fraction * values.get(index);
            W -= fraction * weights.get(index);
        }
        return totalVal;
    }



    // 416: Partition Equal Subset Sum
    /*
    would think to sort here. < - nope.
    oh this is not going to be efficient. get the sum of all numbers in the array.
    here the capacity is treated differently from the
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true; // base case
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                if (dp[sum]) return true; // early stopping, it's not sum + 1 it's just sum
                dp[j] = (dp[j]) || (dp[j-nums[i]]);
            }
        }
        return dp[sum];
    }


    // 494 target sum:
    /*
    ok this is knapsack problem with a twist. instead of take/skip I think it's add/subtract. the size of the
    dp array here isn't simply target + 1 because you could go deep into the negatives. I think the range would
    have to be 2*sum + 1 for all positives, negatives, and +1 for 0. dp[0] initialized to 1 as base case bc there's
    one way to get a zero sum (not adding or subtracting anything).

    OH dp is the old one that's being checked against. My thought process was that you just increment by 1 if
    you reach a new sum.

    Incorrect in-place dp approach and why it's wrong: you would overcount basically.
    for (int i = 0; i < nums.length; i++) {
        for (int k = 0; k < 2 * sum + 1; k++) {
            if (dp[k] != 0) {
                dp[k + nums[i]] += dp[k];  // Incorrect: Modifies dp directly
                dp[k - nums[i]] += dp[k];  // Incorrect: Modifies dp directly
            }
        }
    }

    I am thinking you'd need to preserve the base case throughout but no.
    No need to keep the initial 1:  You don't need to explicitly maintain dp[sum] = 1 after the first iteration
    because the count for the sum of 0 (if it's still reachable) will be correctly reflected in other indices of the dp array.

    so this is tabulation with a reset/update
    edit: need to
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (target > sum || target < (-1 * sum)) return 0; // wouldn't have thought this.
        int[] dp = new int[2*sum + 1];
        Arrays.fill(dp, 0);
        dp[sum] = 1; // 0
        for (int i = 0; i < nums.length; i++) {
            int[] next = new int[2*sum + 1];
            Arrays.fill(next, 0);
            for (int j = 0; j < 2*sum+1; j++) {
                if (dp[j] != 0) {
                    next[j + nums[i]] += dp[j];
                    next[j - nums[i]] += dp[j];
                }
            }
            dp = next;
        }
        return dp[target + sum];
    }


}
