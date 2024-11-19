package com.codeforces.contests.Div3Round988.SharkySurfing;

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
                for (int i = 0; i < t; i++) {
                    int n = sc.nextInt();
                    int m = sc.nextInt();
                    long L = sc.nextLong();
                    List<Long[]> obstacles = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        obstacles.add(new Long[] {sc.nextLong(), sc.nextLong()});
                    }
                    List<Long[]> powerUps = new ArrayList<>();
                    for (int k = 0; k < m; k++) {
                        powerUps.add(new Long[] {sc.nextLong(), sc.nextLong()});
                    }
                    System.out.println(minimumPowerUps(L, obstacles, powerUps));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    private static int minimumPowerUps(Long dist, List<Long[]> obstacles, List<Long[]> powerUps) {
        for (int i = 0; i < obstacles.size(); i++) {
            System.out.println(obstacles.get(i)[0] + " " + obstacles.get(i)[1]);
        }
        List<Long> dp = new ArrayList<>();
        for (long i = 0; i <= dist; i++) {
            dp.add(Long.MAX_VALUE);
        }
        dp.set(0, 1L);

        return 0;
    }
}