package com.codeforces.inprogress.NastyPotions;

import java.util.*;

/*
    Round 888 (Div. 3) Problem E
 */
public class Main {
    public static void main(String[] args) {
        try {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            for (int i = 0; i < t; i++) {
                int n = sc.nextInt(); int k = sc.nextInt();
                // System.out.println("n=" + n + ",k=" + k);
                long[] costs = new long[n];
                for (int j = 0; j < n; j++) {
                    costs[j] = sc.nextLong();
                }
                HashMap<Integer, List<Integer>> mixes = new HashMap<>();
                for (int j = 0; j < k; j++) {
                    int p = sc.nextInt();
                    costs[p - 1] = 0; // this is the only place where the weird indexing shows up
                }
                for (int j = 0; j < n; j++) {
                    int m = sc.nextInt();
                    List<Integer> constituents = new ArrayList<>();
                    for (int e = 0; e < m; e++) {
                        constituents.add(sc.nextInt());
                    }
                    mixes.put(j, constituents);
                }
                bfs(costs, mixes);
                for (int j = 0; j < n; j++) {
                    System.out.print(costs[j] + " ");
                }
                if (i < t - 1) System.out.print("\n");
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    private static void bfs(long[] costs, HashMap<Integer, List<Integer>> mixes) {
        int n = costs.length;
        int[] indegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> mix = mixes.get(i);
            indegree[i] = (costs[i] == 0 || mix.isEmpty()) ? 0 : mix.size();
            if (indegree[i] != 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int potion = queue.poll();
            List<Integer> mix = mixes.get(potion);
            int neighborIndegree = 0;
            long cost = 0;
            for (int i = 0; i < mix.size(); i++) {
                int neighbor = mix.get(i);
                cost += costs[neighbor - 1]; // nvm shows up again here
                neighborIndegree += indegree[neighbor - 1];
            }
            if (indegree[potion] == 0) {
                continue;
            } else if (neighborIndegree == 0) {
                costs[potion] = Math.min(cost, costs[potion]);
                indegree[potion] = 0;
                continue;
            } else {
                costs[potion] = Math.min(cost, costs[potion]);
                indegree[potion] = Math.min(neighborIndegree, indegree[potion]);
                queue.offer(potion);
            }
        }
    }

}
