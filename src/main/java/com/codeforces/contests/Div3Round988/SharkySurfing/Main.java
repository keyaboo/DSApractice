package com.codeforces.contests.Div3Round988.SharkySurfing;

import java.util.*;

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
    /*
    this isn't a dp problem. you have a priorityqueue of the stuff sharky comes across, like you're probably going
    to see a powerup before an obstacle. obstacle[1] and powerUp[1] and the marking of 1L/0L are just data, like
    storing an index in an event-based pq.
     */
    private static int minimumPowerUps(Long dist, List<Long[]> obstacles, List<Long[]> powerUps) {
        List<List<Long>> events = new ArrayList<>();
        for (Long[] obstacle : obstacles) {
            events.add(Arrays.asList(obstacle[0], obstacle[1], 1L)); // Hurdle events (using 1L for long)
        }
        for (Long[] powerUp : powerUps) {
            events.add(Arrays.asList(powerUp[0], powerUp[1], 0L)); // Power-up events (using 0L)
        }
        events.sort(Comparator.comparingLong(a -> a.get(0)));
        Integer k = 1;
        PriorityQueue<Integer> pwr = new PriorityQueue<>(Collections.reverseOrder());
        for (List<Long> event : events) {
            long a = event.get(0);
            long b = event.get(1);
            long type = event.get(2);
            if (type == 0) {
                pwr.offer(Math.toIntExact(b));
            } else {
                while (!pwr.isEmpty() && k < b - a + 2) { // inclusive so +2
                    k += pwr.poll();
                }
                if (k < b - a + 2) { // the interval is bigger than maximum jump
                    return -1;
                }
            }
        }
        return powerUps.size() - pwr.size();
    }
}