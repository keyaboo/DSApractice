package com.leetcode.inprogress;

import java.util.HashMap;
import java.util.Stack;

public class MovePiecesObtainString_2337 {
    /*
    my first thought would be to see whether the nonspace characters are aligned by having counters
    for start and target and seeing whether, when they happen to be equal, they're the same. but I'm
    guessing for half the test cases that check would only happen at the end of both strings, not really
    a great idea and a stack would probably do a better job than counters. the order of L/R as you go
    from left to right does matter, what doesn't matter is whether the L's in target appear at an earlier
    index or the R's at a later. make the stacks talk to one another maybe? funny how I had the code for

    edit: it's just an array problem, not even a for loop. that's all I know. ok it was really easy
    you just keep looking one character at a time. oh i messed up it was '_' not space.
     */
    public boolean canChange(String start, String target) {
        int n = start.length();
        if (target.length() != n) return false;
        int index = 0;
        int targetLetter = 0;
        while (index < n && targetLetter < n) {
            while (targetLetter < n && target.charAt(targetLetter) == '_') {
                targetLetter++;
            }
            while (index < n && start.charAt(index) == '_') {
                index++;
            }
            if (index < n && targetLetter < n) {
                if (start.charAt(index) != target.charAt(targetLetter)) {
                    return false;
                }
                if (start.charAt(index) == 'R' && (index > targetLetter)
                        || start.charAt(index) == 'L' && targetLetter > index) {
                    return false;
                }
            }
            index++;
            targetLetter++;
        }
        return true;
    }
}
