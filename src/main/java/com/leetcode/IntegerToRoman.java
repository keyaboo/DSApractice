package com.leetcode;

/*
 * determine the thousand's place value with x % 1000
 * 
 */

public class IntegerToRoman {

	public static void main(String[] args) {
		int num = 3;
		int[] divisors = new int[]{ 1000, 500, 100, 50, 10, 5, 1};
		char[] characters = new char[] {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
		int divisorsIndex = 0;
		StringBuilder s = new StringBuilder();
		int R = num;
		for (int i = 0; i < divisors.length; i= i + 2) {
			if(i == 0) {
				int base10num = num / (divisors[i]);
				if (base10num > 0) {
				R = num - (base10num*divisors[i]);
				System.out.println("firstR=" + R);
				for (int j = 0; j < base10num; j++) {
				s.append(characters[i]);
					}
				} else {
					continue;
				}
			} else if (num / (divisors[i]) > 0){
				int modNum = R / divisors[i];
				System.out.println("divisors[i]"+ divisors[i]);

				System.out.println("modNum=" + modNum);
				System.out.println("R=" + R);
				if (modNum == 9) {
					s.append(characters[i]);
					s.append(characters[i-2]);
					R = R - (modNum * divisors[i]);
				} else if ((modNum) > 0 && (modNum < 4)) {
					for (int k = 0; k < modNum; k++) {
						s.append(characters[i]);
					}
					R = R - (modNum) * divisors[i] ;
				} else if (modNum == 4) {
					s.append(characters[i]);
					s.append(characters[i-1]);
					R = R - (4 * divisors[i]);
				} else if ((modNum) > 4 && ((modNum) < 9)) {
					s.append(characters[i-1]);
					int mult = (R - divisors[i-1]) / divisors[i];
					for (int k = 0; k < mult; k++) {
						s.append(characters[i]);
					}
					R = R - (modNum) * divisors[i] ;

				}
				} else {
					continue;
				}
			}
		
		System.out.println(s);

		}
		
    public static String intToRoman(int num) {
        return null;
    }

}
