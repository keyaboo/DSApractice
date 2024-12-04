package com.codeforces.contests.Div2Round172.CompetitiveFishing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {

            int t = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < t; i++) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                sc.nextLine();
                // System.out.println("n:" + n + " k:" + k);
                String arr = sc.nextLine();
                int res = calculateMinimumGroups(n, k, arr);
                System.out.println(res);
            }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }

    }
    /*
    what I thought to do was create the maximum number of groups and compute the sum. it's tough to know
    whether that actually produces the largest possible sum or not, I don't really know. Then from that max
    number of groups subtract off the largest terms until your sum is less than k.


     */
    private static int minimumGroups(String fishes, int n, int k) {
        int surplus = 0;
        List<Integer> breakpointIndices = new ArrayList<>();
        for (int i = fishes.length() - 1; i >= 1; i--) {
            if (fishes.charAt(i) == '0') surplus--;
            else surplus++;
            if (surplus > 0) {
                surplus = 0;
                breakpointIndices.add(i-1);
            }
        }
        // this is a loop where the i is actually important.
        int sum = 0;
        for (int i = 0; i < breakpointIndices.size(); i++) {
            sum += (breakpointIndices.size() - i);
        }
        System.out.println("sum: " + sum + " k: " + k);
        if (sum >= k) {
            int groups = breakpointIndices.size();
            while (sum > k && groups > 2) {
                sum -= groups;
                groups--;
            }
            System.out.println("groups: " + groups);
            return groups;
        }
        return -1;
    }

    private static int calculateMinimumGroups(int n, int k, String s) {
        List<Integer> vals = new ArrayList<>();
        int sum = 0;
        for (int i = n - 1; i > 0; i--) {
            sum += (s.charAt(i) == '1' ? 1 : -1); // this is so efficient and clever.
            if (sum > 0) {
                vals.add(sum); // only concerned with count not the actual indices, found that out later.
            }
        }
        Collections.sort(vals);
        int ans = 1;
        while (k > 0 && !vals.isEmpty()) {
            k -= vals.get(vals.size() - 1);
            vals.remove(vals.size() - 1);
            ans++;
        }
        return (k > 0 ? -1 : ans);
    }
}
