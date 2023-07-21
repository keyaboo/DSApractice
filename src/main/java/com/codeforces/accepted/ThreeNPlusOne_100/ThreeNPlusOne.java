package com.codeforces.accepted.ThreeNPlusOne_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
    this is a dp problem, create a map of the numbers encountered in the first few goes at it and hope you reach it again.
    It's not a dp problem really, though they should make the range wide enough that it should be.
 */
public class ThreeNPlusOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> inputPairs = new ArrayList<>();
        while (sc.hasNextLine()) {
            int[] range = new int[2];
            String line = sc.nextLine();
            String[] values = line.split(" ");
            if (values.length == 2) {
                range[0] = Integer.parseInt(values[0]);
                range[1] = Integer.parseInt(values[1]);
            }
            inputPairs.add(range);
        }
        for (int i = 0; i < inputPairs.size(); i++) {
            int maxCycle = maxCycles(inputPairs.get(i));
            System.out.println(inputPairs.get(i)[0] + " " + inputPairs.get(i)[1] + " " + maxCycle);
        }
    }

    private static int getCollatzSuccessor(int n) {
        return ((n & 1) == 1) ? ((3 * n) + 1) : (n / 2);
    }
    private static int maxCycles(int[] range) {
        int min = range[0];
        int max = range[1];
        int maxCount = 0;
        int maxIndex = min;
        HashMap<Integer, Integer> collatzLengthMemo = new HashMap<>();
        collatzLengthMemo.put(1, 1);
        collatzLengthMemo.put(2, 2);
        for (int i = min; i <= max; i++) {
            if (i == 1) {
                continue;
            }
            int val = i;
            ArrayList<Integer> sequence = new ArrayList<>();
            int stepsAhead = 0;
            while (val != 1) {
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
            maxCount = Math.max(maxCount, collatzLengthMemo.get(i));
//            if (collatzLengthMemo.get(i) == maxCount) {
//                maxIndex = i;
//            }
        }
//        System.out.println("maxIndex= " + maxIndex + " ,steps=" + collatzLengthMemo.get(maxIndex));

        return maxCount;
    }

}
