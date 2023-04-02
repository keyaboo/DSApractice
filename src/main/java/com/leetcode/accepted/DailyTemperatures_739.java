package com.leetcode.accepted;

import java.util.Stack;

/**
 * ok I see what you're supposed to do. the stack houses the indices of the temps, not the actual values
 * I was seeing temps[stack.peek()] and going wth that seems wrong.
 * takeaway: default int value is 0 even for arrays, which was handy on this problem since we didn't need to
 * do anything.
 */
public class DailyTemperatures_739 {
    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] solution = dailyTemperatures(temperatures);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] solution = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                solution[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        return solution;

    }

    }
