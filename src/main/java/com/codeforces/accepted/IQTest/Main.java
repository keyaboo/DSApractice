package com.codeforces.accepted.IQTest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(oddOrEvenOut(nums));
        }
    }
    /*
    leverage the fact that the outlier only appears once.
     */
    private static int findOutlier(int[] nums) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                odd=odd + i;
            } else {
                even= even + i;
            }
        }
        return Math.min(odd, even);
    }

    // this is bad
    private static int oddOrEvenOut(int[] nums) {
        int indexOdd = 0;
        int indexEven = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                indexOdd = i;
            } else {
                indexEven = i;
            }
        }
        int outlier = Math.min(indexOdd, indexEven);
        if (outlier == nums.length - 2) {
            if ((nums[nums.length- 1] & 1) == (nums[nums.length-3] & 1)) {
                return nums.length - 1;
            } else {
                return nums.length; // index 0 is 1 this is silly
            }
        }
        return outlier + 1;
    }
}
