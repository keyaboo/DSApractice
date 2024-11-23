package com.leetcode.inprogress;

import java.util.Arrays;

/*
2 arrays of possibly equal size or possibly right bigger than left filled with arbitrary numbers with the objective
of getting both to add up as close to target as possible. Very easy to imagine this as an n! kind of problem.
Even number of integers for nums that makes things easier, I wasn't sure whether to make target (n/2) or (n/2) + 1
depending on whether sum was odd or even but probably safe to make it (n/2).

 */
public class PartitionArrayTwoMinimizeSumDiff_2035 {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        if (n == 2) return Math.abs(nums[1] - nums[0]);
        int[][] lists1 = generate(Arrays.copyOfRange(nums, 0, n / 2));
        int[][] lists2 = generate(Arrays.copyOfRange(nums, n / 2, n));
        int ans = Integer.MAX_VALUE;
        for (int d = 0; d <= n / 2; d++) {
            int[] arr1 = lists1[d], arr2 = lists2[d];
            int k = arr1.length;
            int i1 = 0, i2 = 0; // we use two pointers to find two elements in arr1, arr2 with minimum absolute difference
            while (i1 < k && i2 < k) {
                int diff = arr1[i1] - arr2[i2];
                ans = Math.min(ans, Math.abs(diff));
                if (diff <= 0) i1++;
                if (diff >= 0) i2++;
            }
        }
        return ans;
    }


    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static int[][] generate(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) total += num;
        int[][] ans = new int[n + 1][];
        int[] pos = new int[n + 1];
        for (int i = 0, binomial = 1; i <= n; i++) {
            ans[i] = new int[binomial];

            binomial = binomial * (n - i) / (i + 1);
        }

        // Instead of bit manipulation, use nested loops to generate all combinations
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                int sum1 = 0;
                int[] combination = getCombination(nums, i, j); // Helper function (see below)
                for (int num : combination) {
                    sum1 += num;
                }
                int sum2 = total - sum1;
                ans[i][j] = sum1 - sum2;
            }
        }

        for (int[] arr : ans) Arrays.sort(arr);
        return ans;
    }

    private static int[] getCombination(int[] nums, int i, int j) {
        int[] combination = new int[i];
        int index = 0;
        // Instead of using j as a direct index, generate combinations based on bit patterns
        for (int k = 0; k < nums.length && index < i; k++) {
            if (((1 << k) & j) != 0) {  // Check if the k-th bit is set in j
                combination[index++] = nums[k];
            }
        }
        return combination;
    }


    private class Solution {
        public int minimumDifference(int[] nums) {
            int n = nums.length;
            if (n == 2) return Math.abs(nums[1] - nums[0]);
            int[][] lists1 = generate(Arrays.copyOfRange(nums, 0, n / 2));
            int[][] lists2 = generate(Arrays.copyOfRange(nums, n / 2, n));
            int ans = Integer.MAX_VALUE;
            for (int d = 0; d <= n / 2; d++) {
                int[] arr1 = lists1[d], arr2 = lists2[d];
                int k = arr1.length;
                int i1 = 0, i2 = 0; // we use two pointers to find two elements in arr1, arr2 with minimum absolute difference
                while (i1 < k && i2 < k) {
                    int diff = arr1[i1] - arr2[i2];
                    ans = Math.min(ans, Math.abs(diff));
                    if (diff <= 0) i1++;
                    if (diff >= 0) i2++;
                }
            }
            return ans;
        }

        private int[][] generate(int[] nums) {
            int n = nums.length;
            int total = 0;
            for (int num : nums) total += num;
            int[][] ans = new int[n + 1][];
            int[] pos = new int[n + 1];
            for (int i = 0, binomial = 1; i <= n; i++) {
                ans[i] = new int[binomial]; // number of ways to choose i from n = binomial(i,n)
                binomial = binomial * (n - i) / (i + 1);
            }
            int maxValue = 1 << n;
            for (int key = 0; key < maxValue; key++) {
                int sum1 = 0;
                for (int i = 0; i < n; i++) {
                    if ((key >> i & 1) == 1) sum1 += nums[i];
                }
                int sum2 = total - sum1;
                int bits = Integer.bitCount(key);
                ans[bits][pos[bits]++] = sum1 - sum2;
            }
            for (int[] arr : ans) Arrays.sort(arr);
            return ans;
        }
    }

}
