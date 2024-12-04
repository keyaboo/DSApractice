package com.leetcode.inprogress;

public class MakeStringSubsequenceCyclicIncrements_2825 {
    /*
    subsequence is like, ac is a subsequence of abc because the order is preserved but the string is obviously
    smaller and different.
     */
    public boolean canMakeSubsequence(String str1, String str2) {
        String temp = str1;
        str1 = (str1.length() >= str2.length()) ? str1 : str2;
        str2 = (str2.length() > str1.length()) ? str2 : temp; // I thought to flip the order of this but no.
        // System.out.println((char) findModuloCharacter('z', 4) + 'a');
        // int ascii = findModuloCharacter('z', 4) + 'a';
        for (int i = 0; i < str1.length(); i++) {
            int diff = Math.abs(str1.charAt(0) - str2.charAt(0));
            // diff = (str1.charAt(0) > str2.charAt(0)) ?
        }
        return false;
    }

    private static int findModuloCharacter(char c, int i) {
        return (((c - 'a') + i) % 26);
    }

    public static void main(String[] args) {
        MakeStringSubsequenceCyclicIncrements_2825 object = new MakeStringSubsequenceCyclicIncrements_2825();
        object.canMakeSubsequence("", "");
    }
}
