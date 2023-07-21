package com.codeforces.inprogress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
    this is a dp problem, create a map of the numbers encountered in the first few
 */
public class ThreeNPlusOneProblem {

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
//            int maxCycle = maxCycles(inputPairs.get(i));
            int maxCycle = 0;
//            System.out.println(inputPairs.get(i)[0] + " " + inputPairs.get(i)[1] + " " + maxCycle);
        }
        int[] dummy = new int[2];
        dummy[0] = 2;
        dummy[1] = 10;
        maxCycles(dummy);
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
        for (int i = min; i <= max; i++) {
            if (min == 1) {
                collatzLengthMemo.put(1, 1);
                continue;
            }
            int val = i;
            ArrayList<Integer> sequence = new ArrayList<>();
            int stepsAhead = 0;
            while (val != 1) {
                sequence.add(val);
                if (collatzLengthMemo.containsKey(val)) {
                    stepsAhead = collatzLengthMemo.get(val);
                    break;
                } else {
                    val = getCollatzSuccessor(val);
                }
            }
            for (int j = sequence.size() - 1; j >= 0; j--) {
                collatzLengthMemo.put(sequence.get(j), j + stepsAhead);
            }
            maxCount = Math.max(maxCount, collatzLengthMemo.get(i));
            if (collatzLengthMemo.get(i) == maxCount) {
                maxIndex = i;
            }
        }
        System.out.println("maxCount= " + maxCount + "maxIndex= " + maxIndex);
        return 0;
    }

    }
