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
 *
 *
 */
public class DailyTemperatures_739 {

	public static void main(String[] args) {
		int[] temperatures = new int[] {73,74,75,71,69,72,76,73};
		System.out.println(useStack(temperatures));
	}
	// monotonically decreasing stack I think is the play here
	public static int[] useStack(int[] temps) {
		Stack<Integer> stck = new Stack<>();
		ArrayList<Integer> answers = new ArrayList<>();
		answers.add(0, 9);
		int popCounter = 0;

		for (int i = 0; i < temps.length; i++) {
			if (stck.isEmpty() || temps[i] <= stck.peek()) {
				stck.push(temps[i]);
				popCounter = 0;
			} else {
				while (temps[i] >= stck.peek()) {
					popCounter++;
					answers.add(answers.size()-popCounter, popCounter);
					stck.pop();
					if (stck.isEmpty()) {
						break;
					}
				}
				stck.push(temps[i]);
				System.out.println("debug");
			}

		}
		System.out.println(answers);
		return answers.stream().mapToInt(i -> i).toArray();
	}



	/*
	this is garbage the
	 */
	
	
	

}
