package com.leetcode.accepted;

/*
3 things keep getting messed up. the stop condition on the second loop is comparing current value to j (0 - 9), you
don't need to invoke last seen yet. What you're looking for first is a 9 first and it has to be after the value being
looked at. It may be better to make a variable for the last value index, the thing coming out of the last seen
array because of how many mistakes were made accessing that thing.
 */
public class MinimumSwap_670 {
    public int maximumSwap(int num) {
        char[] numArr = String.valueOf(num).toCharArray();
        int n = numArr.length;
        int[] lastSeen = new int[10];
        for (int i = 0; i < n; i++) {
             char c = numArr[i];
             lastSeen[c - '0'] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 9; j > numArr[i] - '0'; j--) {
                        if (lastSeen[j] > i) {
                            int furthestIdx = lastSeen[j];
                            char small = numArr[i];
                            numArr[i] = numArr[furthestIdx];
                            numArr[furthestIdx] = small;
                            return Integer.parseInt(new String(numArr));
                        }
            }
        }
        return num;
    }
}
