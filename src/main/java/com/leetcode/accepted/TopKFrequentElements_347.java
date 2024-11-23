package com.leetcode.accepted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
how is this different from bucketsort: no need to sort probably? this is only somewhat similar to bucket sort
in the sense that you have a bunch of lists with some criteria for their ordering (numerical position compared to
frequency of appearance) and you sort of gather the elements from each of the buckets.
 */
public class TopKFrequentElements_347 {
    public static int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }
        int maxFrequency = 0;
        for (int frequency : freqs.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }
        List<List<Integer>> buckets = new ArrayList<>(maxFrequency + 1);
        for (int i = 0; i <= maxFrequency; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int num : freqs.keySet()) {
            int freq = freqs.get(num);
            buckets.get(freq).add(num);
        }
        int[] res = new int[k];
        int resIdx = 0;
        for (int pos = buckets.size() - 1; pos >= 0 && resIdx < k; pos--) {
            List<Integer> bucket = buckets.get(pos);
            for (int j = 0; j < bucket.size() && resIdx < k; j++) {
                res[resIdx++] = bucket.get(j);
            }
        }
        return res;
    }

    /*
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,2,3,3,3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        for (int i = 0; i < k; i++) {
            System.out.println(res[i]);
        }
    }
     */

}
