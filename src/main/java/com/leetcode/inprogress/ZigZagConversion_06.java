package com.leetcode.inprogress;

/**
 * @author christian
 * one of the earliest problems I tried, I don't think it passes
 */
public class ZigZagConversion_06 {
	
	private static String zagConverter(String s, int numRows) {
		String total = "";
		int cornerSpacing = 2 * numRows - 2;
		
		for (int z = 0; z < numRows; z++) {
			String rowString = "";
			for (int j = 0; j < s.length(); j++) {
				try {
					
				char firstString = s.charAt(z + (j * cornerSpacing));
				
				
				rowString = rowString + firstString;
				
				
				} catch (java.lang.StringIndexOutOfBoundsException ez) {
					continue;
				}
				
				
				try {
				
					if (z != 0 && z != numRows - 1) {
						char secondString = s.charAt(((j * cornerSpacing) + cornerSpacing - z));
				
						rowString = rowString + secondString;
					}
					
				} catch (java.lang.StringIndexOutOfBoundsException ez2) {
					continue;
				}
			}

			total = total + rowString;
		}

		
		
		return total;
	}
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		System.out.println(zagConverter(s, 3));
	}
	
	public static void Secondmain(String[] args) {
		String s = "PAYPALISHIRING";
		
		int zagLength = 3;
		int cornerSpacing = 2 * zagLength - 2;
		
		
		String corners = "";
		String secondRow = "";
		int i = 0;
		while (((cornerSpacing * i) + zagLength) < s.length()) {
			

			corners = corners + s.charAt(zagLength - 1 + i * cornerSpacing);

			i += 1;
		}
		
		String firstString = "";
		for (int j = 0; j < s.length(); j++) {
			try {
			firstString = firstString + s.charAt(j * cornerSpacing);
			} catch (java.lang.StringIndexOutOfBoundsException ez) {
				continue;
			}
		}
		String total = "";
		
		for (int z = 0; z < zagLength; z++) {
			String rowString = "";
			for (int j = 0; j < s.length(); j++) {
				try {
				rowString = rowString + s.charAt(z + (j * cornerSpacing));
				} catch (java.lang.StringIndexOutOfBoundsException ez) {
					continue;
				}
			}

			total = total + rowString;
		}
		System.out.println(total);
		
		/*
		for (int i = 0; ((cornerSpacing * i) + zagLength) < s.length(); i++) {
			// System.out.println(s.charAt(zagLength - 1 + i * cornerSpacing));
			
			corners = corners + s.charAt(zagLength - 1 + i * cornerSpacing);
			
			// System.out.println(s.charAt(zagLength - 2 + i* cornerSpacing));
			// System.out.println(s.charAt(zagLength + 0 + i* cornerSpacing));

		}
		
		
		for (int i = 0; ((cornerSpacing * i) + zagLength) < s.length(); i++) {

		}
		*/
		
		System.out.println(corners);
		System.out.println(firstString);
		
	}

}
