package com.codeforces.accepted.ThreeNPlusOne_100;

/*
    uva 100 - The 3n + 1 problem
    if hashmap is instantiated for every input it's 2.960 seconds which just barely makes the cutoff
    if it's a global variable, 1.150 seconds which is a speedup but not faster than no dp.
    no dp about 4x faster even for crazy inputs, too much time instantiating vectors w/ my approach probably.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            long start_time = System.currentTimeMillis();
            HashMap<Long, Integer> collatzLengthMemo = new HashMap<>();
            collatzLengthMemo.put(1L, 1);
            collatzLengthMemo.put(2L, 2);
            Scanner sc = new Scanner(System.in);
            int first, second;
            while (sc.hasNext()) {
                first = sc.nextInt();
                second = sc.nextInt();
                int res = maxCycles(Math.min(first, second), Math.max(first, second), collatzLengthMemo);
                System.out.println(String.format("%d %d %d", first, second, res));
            }
            long end_time = System.currentTimeMillis();
            System.out.println(end_time - start_time);
        }
        private static long getCollatzSuccessor(long n) {
            return ((n & 1) == 1) ? ((3 * n) + 1) : (n / 2);
        }
        private static int maxCycles(int min, int max, HashMap<Long, Integer> collatzLengthMemo) {
            int maxCount = 1;
            for (int i = Math.max(2, min); i <= max; i++) {
                long val = i;
                ArrayList<Long> sequence = new ArrayList<>();
                int stepsAhead = 0;
                while (val != 1L) {
                    if (collatzLengthMemo.containsKey(val)) {
                        stepsAhead = collatzLengthMemo.get(val);
                        break;
                    } else {
                        sequence.add(val);
                        val = getCollatzSuccessor(val);
                    }
                }
                for (int j = 0; j < sequence.size(); j++) {
                    if (!(collatzLengthMemo.containsKey(sequence.get(j)))) { // this is only for the value 2
                        collatzLengthMemo.put(sequence.get(j), sequence.size() - j + stepsAhead);
                    }
                }
                maxCount = Math.max(maxCount, collatzLengthMemo.get((long) i));
            }
            return maxCount;
        }

}
