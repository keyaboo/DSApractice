package com.codeforces.contests.Div2Round172.ColoredMarbles;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {

                int t = sc.nextInt();
                for (int i = 0; i < t; i++) {
                    int n = sc.nextInt();
                    Integer[] arr = new Integer[n];
                    for (int j = 0; j < n; j++) {
                        arr[j] = sc.nextInt();
                    }
                    int res = countScore(arr);
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
so I guess what I did here was overcount by incrementing score every time and then subtract
off from score if it was really Bob's marble.
 */
    public static int countScore(Integer[] arr) {
        HashMap<Integer, Integer> freqs = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            freqs.put(arr[i], freqs.getOrDefault(arr[i], 0) + 1);
        }
        int score = 0;
        int turn = 0;
        for (int num : freqs.keySet()) {
            if (freqs.get(num) == 1) {
                if (turn % 2 == 0) {
                    score++;
                } else {
                    score--;
                }
                turn++;
            }
            score += 1;
        }
        return score;
    }
}