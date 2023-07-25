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
            System.out.println(findOutlier(nums));
        }
    }
    /*
    leverage the fact that the outlier only appears once and count up indices for comparison
    silly but I thought of a test case for 2 2 2 1 or whatever
     */
    private static int findOutlier(int[] nums) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                odd+= i;
            } else {
                even+= i;
            }
        }
        return (odd == even) ? 4 : Math.min(odd, even);
    }

}
