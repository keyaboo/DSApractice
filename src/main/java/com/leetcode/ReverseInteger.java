package com.leetcode;

import java.util.ArrayList;

public class ReverseInteger {

	public static void main(String[] args) {
		int x = 1534236469;
		boolean negative = (x < 0);
		if (negative) { x = (-1) * x;}
		boolean largestDigitFound = false;
		double mantissa = 0;
		while (!(largestDigitFound)) {
			if (x - Math.pow(10, mantissa) < 0) {
				largestDigitFound = true;
			} else {
				mantissa++;
			}
		}
		ArrayList<Integer> reverse = new ArrayList<Integer>();
		for (int i = (int) mantissa - 1; i >= 0; i--) {
			boolean halt = false;
			for (int k = 0; !halt; k++) {
				double subtraction = x - (k) * (Math.pow(10.0, (double) i));
				if (subtraction < 0) {
					halt = true;
					reverse.add((k - 1));
					x =  (int) (x - ((k - 1) * (Math.pow(10.0, (double) i))));
				}
				
			}
		}
		int reversedNumber = 0;
		for (int i = reverse.size() - 1; i >= 0; i--) {
		System.out.println(reverse.get(i));
		reversedNumber = (int) (reversedNumber + (Math.pow(10, i) * reverse.get(i)));
		}
		if ((reversedNumber > Math.pow(2, 31) - 1) || reversedNumber < -1 * Math.pow(2, 31)) {
			System.out.println(0);
		}
		else if (negative) {
			System.out.println((-1 * reversedNumber));
		} else {
		System.out.println(reversedNumber);
		}
	}

}
