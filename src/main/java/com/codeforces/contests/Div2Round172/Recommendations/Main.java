package com.codeforces.contests.Div2Round172.Recommendations;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {

                int t = sc.nextInt();
                for (int i = 0; i < t; i++) {
                    int n = sc.nextInt();
                    Long[][] tracks = new Long[n][2];
                    for (int j = 0; j < n; j++) {
                        tracks[j][0] = sc.nextLong();
                        tracks[j][1] = sc.nextLong();
                    }
                    List<Long> res = fnName(tracks);
                    for (int k = 0; k < res.size(); k++) {
                        System.out.println(res);
                    }
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }

    }

    /*
    my thought is to do a min heap based on the first interval value. But from there what happens?
    you'd have overlapping intervals,and in order to determine the number of strongly recommended
    tracks you'd need to find the next largest interval over that range and count the difference.
    So sort based on interval width rather than interval start? binary search for it but what kind
    of data structure could preserve the interval history. you could start from the end but it'd take
    forever. or you could have one long array and fill it in with values and some sort of marker
    as to whether it was a start or end. bit manipulation?
     */
    private static List<Long> fnName(Long[][] segments) {
        List<Long> tracks = new ArrayList<>();
        HashMap<Long, List<Integer>> indexByValue = new HashMap<>();
        for (int i = 0; i < segments.length; i++) {
            long start = segments[i][0];
            long end = segments[i][1];
            indexByValue.put(start, indexByValue.computeIfAbsent(start, k -> new ArrayList<>())).add(i);
            indexByValue.put(end,indexByValue.computeIfAbsent(start, k -> new ArrayList<>())).add(-i);
        }
        /*
        while (!pq.isEmpty()) {
            Long[] curr = pq.poll();

        }

         */
        return null;
    }
}