package com.IndianWebsite;

import java.util.HashMap;

/*
I think here you want to have a hashmap, don't update if something already exists. Basically tried to model this
on a pair of 2, -2 adjacent to make sure that would work.

I messed up the notion of length thinking like this, which should be only 1. I tried +1 in the max function.

LOL that's exactly what I was trying to do design this around. didn't think to do the negative index for 0.
 */
public class Largestsubarraywith0sum {
    int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> indexBySum = new HashMap<>();
        int sum = 0;
        indexBySum.put(0, -1);
        int largest = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (!indexBySum.containsKey(sum)) {
                indexBySum.put(sum, i);
            } else {
                largest = Math.max(largest, i - indexBySum.get(sum));
            }
        }
        return largest;
    }
}
