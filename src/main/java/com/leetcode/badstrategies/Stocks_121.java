package com.leetcode.badstrategies;

/**
 * this seems very similar to daily temperatures
 * problem I ran into was a tie because of the else clause. one way to solve is to check prices[right-1] against
 * prices[highestIndex] but that's more prone to making a mistake, better to just do a check for 3 element array
 * where they both would normally be skipped
 */
public class Stocks_121 {
    public static void main(String[] args) {
        // int[] prices = new int[] {1,4,2};
        int[] prices = new int[] {1,2,4,2,5,7,2,4,9,0,9};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = prices.length - 1;
        int profit = 0;
        int highestIndex = right;
        int lowestIndex = left;
        while (left < right) {
            if (prices[right-1] > prices[highestIndex]) {
                highestIndex = right-1;
                right--;
            } else if (prices[left+1] < prices[lowestIndex]) {
                lowestIndex = left+1;
                left++;
            }
            else {
                if (right - left - 1 > 0 && !(prices[left + 1] > prices[highestIndex])){
                    left++;
                }
                if (right - left - 1 > 0 && !(prices[right - 1] < prices[lowestIndex])) { // stay put on right if you know the next value is already lower
                    right--;
                };
                if (prices[right - 1] < prices[lowestIndex] && prices[left + 1] > prices[highestIndex]) { // tie situation
                    int ldiff = prices[left + 1] - prices[highestIndex];
                    int rdiff = prices[right - 1] - prices[lowestIndex];
                    if (Math.abs(ldiff) > Math.abs(rdiff)) {
                        left++;
                    } else if (Math.abs(ldiff) > Math.abs(rdiff)) {
                        right--;
                    } else {
                        left++; // idk this is such contrived bullshit if it ever makes it here
                    }
                }
            }
            int val = prices[highestIndex] - prices[lowestIndex];
            // System.out.println(val);
            profit = (val > 0 ) ? val : 0;
        }

        return profit;
    }
}
