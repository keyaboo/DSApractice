package com.leetcode.suboptimalsolutions;

import java.util.*;

/**
 * okay you can do it with just one hashmap, it makes the queue longer than my original attempt was though.
 *
 * tried this with key being integer node value, instead of a unidirectedgraph node and it did not work.
 * the loops were correct though. Basically the mapping is original nodes, copies with k,v corresponding.
 * I wasn't quite sure what the rules were about accessing data from the original graph for making an authentic copy
 *
 * also overwriting the map entry may have been my problem which is why it was yelling at me, there's no
 * point messing with keys when you can add neighbors directly to the neighbor's arraylist.
 *
 * did not get a particularly impressive time so this one's going into suboptimal solutions. bfs may just
 * be slower compared to other traversal methods, however.
 */
public class CloneGraph_133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        } // now write the rest of this so that a neighborless node will be processed correctly.
        Node curr = node;
        Queue<Node> traverse = new ArrayDeque<Node>();
        HashMap<Node, Node> storedCopies = new HashMap<>();
        Node copy = new Node(curr.val);
        storedCopies.put(curr, copy);
        traverse.add(curr);
        while (!(traverse.isEmpty())) {
            curr = traverse.poll();
            ArrayList<Node> neighbors = new ArrayList<>();
            for (int i = 0; i < curr.neighbors.size(); i++) {
                Node neighbor = curr.neighbors.get(i);
                // if the map does not contain curr's neighbor, add it to the queue, and create
                // a new association between neighbor in original graph and a copy which just has the value.
                if (!(storedCopies.containsKey(neighbor))) {
                    traverse.add(neighbor);
                    storedCopies.put(neighbor, new Node(neighbor.val));
                }
                storedCopies.get(curr).neighbors.add(storedCopies.get(neighbor));
            }
        }
        return storedCopies.get(node);
    }


    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
