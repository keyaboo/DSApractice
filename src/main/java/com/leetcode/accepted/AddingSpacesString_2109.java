package com.leetcode.accepted;

import java.util.Stack;

/*
maybe use a stack to store the spaces, stringbuilder (append?) yes it is.
the spaces are inserted before the character at the given index, so compare whatever's at TOS
to i + 1. Creating the stack is not necessary, it isn't a while loop because there's a space
that either exists or doesn't for every character in the string.
 */
public class AddingSpacesString_2109 {
    public String addSpacesStack(String s, int[] spaces) {
        int n = spaces.length;
        Stack<Integer> nextSpace = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            nextSpace.push(spaces[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            while (!nextSpace.isEmpty() && nextSpace.peek() < (i + 1)) {
                sb.append(' ');
                nextSpace.pop();
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    /*
    revision: quite a bit faster.
     */
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int spaceIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (spaceIndex < spaces.length && spaces[spaceIndex] < (i + 1)) {
                sb.append(' ');
                spaceIndex++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}
