package com.leetcode.inprogress;

import java.util.ArrayList;

/**
 * @author christian
 * ADM chapter 1 recommended problem
 */
public class DailyTemperatures_739 {

	public static void main(String[] args) {
		int[] temperatures = new int[] {73,74,75,71,69,72,76,73};
		dailyTemperatures(temperatures);
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
