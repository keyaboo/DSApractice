package com.leetcode.inprogress;

import java.util.List;

/**
 * this is my first graph traversal problem. For intiial traversal, could store all edges in
 * https://stackoverflow.com/questions/3287003/three-ways-to-store-a-graph-in-memory-advantages-and-disadvantages
 * https://stackoverflow.com/questions/5493474/graph-implementation-c/5493656#5493656
 *
 */
public class CloneGraph_133 {
    public static void main(String[] args) {

    }

    public Node cloneGraph(Node node) {
        return new Node();
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;
    }


}
