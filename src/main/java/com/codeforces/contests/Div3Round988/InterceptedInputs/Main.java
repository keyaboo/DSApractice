package com.codeforces.contests.Div3Round988.InterceptedInputs;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // List<Integer> primes = sieveOfEratosthenes(20000);
        // primes.set(0, 1);
        try {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {

                int t = sc.nextInt();
                for (int i = 0; i < t; i++) {
                    int k = sc.nextInt();
                    int[] nums = new int[k];
                    HashMap<Integer, Integer> freqs = new HashMap<>(); // For counting integers
                    for (int j = 0; j < k; j++) {
                        nums[j] = sc.nextInt();
                        freqs.put(nums[j], freqs.getOrDefault(nums[j], 0) + 1);
                    }
                    int streamSize = k - 2;
                    findDimensions(streamSize, freqs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }

    }

    public static void findDimensions(int streamSize, HashMap<Integer, Integer> freqs) {
        for (int m = 1; m < 20000; m++) {
            if (freqs.containsKey(m)) {
                if (streamSize % m == 0) {
                    int n = streamSize / m;
                    if (n == m) {
                        if (freqs.get(n) >= 2) {
                            System.out.println(m + " " + n);
                            return;
                        }
                    } else {
                        if (freqs.containsKey(n)) {
                            System.out.println(m + " " + n);
                            return;
                        }
                    }
                }
            }
        }
    }

    /*
    public static List<Integer> sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i+= p) {
                    isPrime[i] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

     */
}