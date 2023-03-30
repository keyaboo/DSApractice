package com.leetcode.inprogress;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author christian
 * ADM chapter 1 recommended problem
 * 3/29/2023 reattempt, I think the idea I had when I first tried this was do a full pass
 * to find the maximums and then split up into subarrays to determine whether there's
 * a sort of local maximum in the subarray. I just googled sliding window technique which
 * I'm not so familiar with and the video suggests it's the perfect method for finding
 * subarrays inside of larger arrays.
 *
 * https://itnext.io/monotonic-stack-identify-pattern-3da2d491a61e
 * solutions make reference to this data structure which I'm gonna explore a bit more.
 * tried with normal stack and that's obviously not working, no idea why this is a recommended
 * problem so early in adm.
 */
public class DailyTemperatures_739 {

	public static void main(String[] args) {
		int[] temperatures = new int[] {73,74,75,71,69,72,76,73};
		dailyTemperatures(temperatures);
	}

	public static void useStack(int[] temps, List<Integer> answer) {
		Stack<Integer> stck = new Stack<>();
		Integer highest = temps[0];
		for (int i = 0; i < temps.length; i++) {
			if (stck.isEmpty() || temps[i] < highest) {
				stck.push(temps[i]);
			} else if (temps[i] > highest) {
				highest = temps[i];
				while (!stck.isEmpty()) {

				}
			}
		}
	}



	/*
	this is garbage the
	 */
	public static int[] dailyTemperatures2(int[] temps) {
		if (temps.length == 1) {
			return new int[]{0};
		}
		int start = 0;
		int stop = start + 1;
		ArrayList<Integer> output = new ArrayList<>();
		while (stop < temps.length) {
			if (stop == temps.length - 1) {

			}

			if (temps[stop] > temps[start]) {
				output.add(start,start-stop);
				if (start - stop > 2) {
					output.add(stop-1,1);
					int left = start + 1;
					int right = stop - 1;
					while (right > start) {

					}
				}

			} else {
				stop++;
			}
		}
		return new int[]{0};
	}

	
	private static void dailyTemperatures(int[] temperatures) {
		int[] answer = new int[temperatures.length - 1];
		ArrayList<Integer> maxPositions = new ArrayList<Integer>();
		int temp = temperatures[0];
		for (int i = 0; i < temperatures.length; i++) {
			if (temperatures[i] > temp) {
				maxPositions.add(i);
			}
		}
		determinePositions(0, temperatures, maxPositions, answer);
	}
	// [1,1,4,2,1,1,0,0]
	private static void determinePositions(int offset, int[] temperatures, ArrayList<Integer> maxPositions, int[] answer) {
		for (int i = 0; i < maxPositions.size(); i++) {
			int x = maxPositions.get(i);
			if (i == 0) {
				answer[offset] = maxPositions.get(i + 1) - maxPositions.get(i);
			} else if (i > 1 && i < maxPositions.size() - 1) {
				offset = maxPositions.get(i);
				answer[offset] = maxPositions.get(i + 1) - maxPositions.get(i);
			}
		}
	}
	
	

}
