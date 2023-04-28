package com.leetcode.accepted;

import java.util.Stack;

/**
 * LISP!
 *
 * This could probably be accomplished just using a stack, perhaps two for evaluated pairs?
 * (4 + 3) * (1 + 7)
 * ^ this looks like it could be fishy
 * ["4", "3", "+" "1" "7" "+" "*"]
 * nvm, 9 + ((4 + 3) * (1 + 7)) in RPE never appear, it would always be (4 + 3) * (1 + 7) + 9, so can do empty
 * checks on the raw stack.
 * for divided by and minus where the order matters, the top of the stack I think should be the first fn param
 * they don't really give an example
 *
 * 1 <= tokens.length <= 104
 * very stupid, they want you to be constantly pushing the evaluated expression back on the stack and return
 * whatever's at the top, kinda ruins the original intent of naming my stack "raw"
 */
public class ReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> raw = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                    int b = raw.pop();
                    int a = raw.pop();
                    raw.push(performOp(a, b, tokens[i]));
            } else {
                raw.push(Integer.valueOf(tokens[i]));
            }
        }
        return raw.pop();
    }

    public static int performOp(int a, int b, String s){
        switch (s) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }
}
