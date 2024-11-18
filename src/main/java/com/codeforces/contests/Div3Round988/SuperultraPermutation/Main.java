package com.codeforces.contests.Div3Round988.SuperultraPermutation;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int t = sc.nextInt();
                for (int i = 0; i < t; i++) {
                    int n = sc.nextInt();
                    List<Integer> res = getPermutation(n);
                    for (int j = 0; j < res.size(); j++) {
                        System.out.print(res.get(j) + " ");
                    }
                    System.out.print("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }

    }
    /*
        the only thing that matters is that we pair 4 and 5 together.
     */
    public static List<Integer> getPermutation(int n) {
        if (n <= 4) return new ArrayList<>(Arrays.asList(-1));
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= n; i += 2) {
            if (i != 4) res.add(i);
        }
        res.add(4);
        res.add(5);
        for (int i = 1; i <= n; i += 2) {
            if (i != 5) res.add(i);
        }
        return res;
    }

    /*
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return false;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
     */

}