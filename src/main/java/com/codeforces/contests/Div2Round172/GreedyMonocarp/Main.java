package com.codeforces.contests.Div2Round172.GreedyMonocarp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {

                int t = sc.nextInt();
                for (int i = 0; i < t; i++) {
                    int n = sc.nextInt();
                    int k = sc.nextInt();
                    Integer[] arr = new Integer[n];
                    for (int j = 0; j < n; j++) {
                        arr[j] = sc.nextInt();
                    }
                    System.out.println(minimumCoins(arr, k));
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }

    }


    private static int minimumCoins(Integer[] arr, int k) {
        Arrays.sort(arr, Collections.reverseOrder());
        int sum = arr[0];
        int fewestCoins = k - sum;
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if (sum <= k) {
                fewestCoins = Math.min(fewestCoins, k - sum);
            }
        }
        return fewestCoins;
    }
}