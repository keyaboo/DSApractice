package com.codeforces.inprogress.RakhshRevival;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/*

 */
public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {

                int t = sc.nextInt();
                for (int i = 0; i < t; i++) {
                    int n = sc.nextInt();
                    int m = sc.nextInt();
                    int k = sc.nextInt();
                    sc.nextLine();
                    String binary = sc.nextLine();
                    // System.out.println(binary);
                    System.out.println(reviveRakhsh(n,m,k,binary));
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }

    }

    /*
    clever use of prefix sum which avoids ever needing to modify the string and perform the strengthening
    on Rakhsh directly. The hard part is identifying that you need two variables, sum and count.
    count keeps track of the current number of consecutive zeroes to identify accumulation criteria.
    sum identifies if a previously application has strengthened the current index value. In Subarray Sum
    Equals K, the hashmap stores information about the cumulative sum and you can have direct lookup.
    Here, the sum variable retains that information, assuming a long string of 0s gets temporarily turned
    to 1 and then the k later doesn't trigger the regular count increment because of the strengthening
    that happened k terms before.
     */
    private static int reviveRakhsh(int n, int m, int k, String binary) {
        int[] arr = new int[n];
        int res = 0;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < binary.length(); i++) {
            sum += arr[i];
            if (sum > 0 || binary.charAt(i) == '1') {
                count = 0;
            } else {
                count++;
                if (count == m) {
                    sum++;
                    res++;
                    count = 0;
                    if (i + k < n) {
                        arr[i+k]--; // this is interesting
                    }
                }
            }
        }
        return res;
    }
}