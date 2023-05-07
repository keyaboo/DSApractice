package com.leetcode.accepted;

import java.util.ArrayList;

/**
 * the difficulty here is resetting the min value in O(1) time whenever there is a pop
 * monotonic stacks could help you if there's only one pop. I am so stupid this is another graph problem.
 * ^ no it's not.
 * a node can have data and a pointer to the last minimum.
 *
 *
 */
public class MinStack_155 {
    ArrayList<Node> nodes;

    public MinStack_155() {
        this.nodes = new ArrayList<>();
    }

    public void push(int val) {
        Node newNode = null;
        if (nodes.isEmpty()) {
            newNode = new Node(val);
            newNode.small = newNode;
        } else {
            int small = this.nodes.get(this.nodes.size() - 1).small.val;
            newNode = new Node(val);
            if (val < small) {
                newNode.small = newNode;
            } else {
                newNode.small = this.nodes.get(this.nodes.size() - 1).small;
            }
        }
        nodes.add(newNode);

    }

    public void pop() {
        this.nodes.remove(this.nodes.get(this.nodes.size() - 1));
    }

    public int top() {
        return this.nodes.get(this.nodes.size() - 1).val;
    }

    public int getMin() {
        return this.nodes.get(this.nodes.size() - 1).small.val;
    }

    private static class Node {
        public Integer val;
        public Node small;

        public Node (int val) {
            this.val = val;
        }

        public Node(int val, Node small) {
            this.val = val;
            this.small = small;
        }


    }


}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
