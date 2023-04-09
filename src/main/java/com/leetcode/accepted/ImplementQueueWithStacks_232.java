package com.leetcode.accepted;

import java.util.Stack;

/**
 * using only two* stacks.
 * Can just have a regular stack for storing everything, and another one being empty and used for copying over
 * values from the first
 *
 *   easy problem just as advertised.
 *
 */
public class ImplementQueueWithStacks_232 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    Integer size = 0;

    // no args constructor fine leaving this the way it is I guess.
    public ImplementQueueWithStacks_232() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    // not really sure what error to catch for empty since return type is primitive.
    public int pop() {
        if (stack1.size() == 1) {
            return stack1.pop();
        } else {
            while (stack1.size() > 1) {
                stack2.push(stack1.pop());
            }
            int returnedValue = stack1.pop();
            while (stack2.size() > 0) {
                stack1.push(stack2.pop());
            }
            return returnedValue;
        }
    }

    public int peek() {
        if (stack1.size() == 1) {
            return stack1.peek();
        } else {
            while (stack1.size() > 1) {
                stack2.push(stack1.pop());
            }
            int peekValue = stack1.peek();
            while (stack2.size() > 0) {
                stack1.push(stack2.pop());
            }
            return peekValue;

        }
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

}
