package com.leetcode.inprogress;

public class MakeStringSubsequenceCyclicIncrements_2825 {
    /*
    subsequence is like, ac is a subsequence of abc because the order is preserved but the string is obviously
    smaller and different.

    This was incredibly sloppy not understanding of the problem at the beginning. str1 and str2 are definite,
    but the code for retrieving longest/shortest is in a void helper function.

    regular subsequence equivalence could probably be like, for abc and ac you'd have a counter for str2
    and not increment it if str1.charat(i) != str2.charAt(idx), and see if it gets to str2.length(), again
    made a mistake wanting to add i+idx to str1. the situation for cyclic increments, since you have two
    candidates and uncertain whether to increment that index. could have three separate counters, a +1,
    a 0. fast & slow pointer problem, except what would the rule be for incrementing them.

    the first hint is to consider the incremented elements separately, they'd both have to get incremented
    i'm guessing because it doesn't matter which one "starts" our overlap. I forgot the constraint on index
    but that's more a failing of my is-subsequence 392 napkin understanding.
     */
    public boolean canMakeSubsequence(String str1, String str2) {
        int idx = 0;
        for (int i = 0; i < str1.length() && idx < str2.length(); i++) {
            int ogAscii = findModuloCharacter(str1.charAt(i), 0);
            int opAscii = findModuloCharacter(str1.charAt(i), 1);
            int str2Ascii = findModuloCharacter(str2.charAt(idx), 0);
            if ((opAscii == str2Ascii) || (ogAscii == str2Ascii)) {
                idx++;
            }
        }
        return idx == str2.length();
    }


    private static int findModuloCharacter(char c, int i) {
        return (((c - 'a') + i) % 26);
    }

    public void assignLongest(String str1, String str2) {
        String temp = str1;
        str1 = (str1.length() >= str2.length()) ? str1 : str2;
        str2 = (str2.length() > str1.length()) ? str2 : temp; // I thought to flip the order of this but no.
    }

}
