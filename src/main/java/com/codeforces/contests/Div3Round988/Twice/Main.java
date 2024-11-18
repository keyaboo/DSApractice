package com.codeforces.contests.Div3Round988.Twice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int t = sc.nextInt();
                for (int i = 0; i < t; i++) {
                    int n = sc.nextInt();
                    int[] arr = new int[n];
                    for (int j = 0; j < n; j++) {
                        arr[j] = sc.nextInt();
                    }
                    System.out.println(maximumScore(arr));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }

    }

    public static int maximumScore(int[] operations) {
        int count = 0;
        HashMap<Integer, List<Integer>> freq = new HashMap<>();
        for (int i = 0; i < operations.length; i++) {
            int num = operations[i];
            if (!freq.containsKey(num)) {
                freq.put(num, new ArrayList<>());
            }
            freq.get(num).add(i);
        }
        for (List<Integer> indices : freq.values()) {
            if (indices.size() >= 2) {
                count += indices.size() / 2;
            }
        }
        return count;
    }

}
