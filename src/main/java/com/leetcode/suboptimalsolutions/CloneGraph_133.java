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
 *
 * similar problem 1490: clone N-ary Tree
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


    /**
     * recursive dfs solution I want to get familiar with
     *
     * hashmap method computeIfAbsent(key, lambdaFunction) is useful to know about, important that it returns
     * the value for whatever was just inserted into the table. the old and boring way to do this would be
     * set value for whatever you have the key for equal to null, do a containskey check, reassign value
     * to map.get(key), otherwise put(key, value whatever), reassign with map.get(key)
     *
     * public V
     *        computeIfAbsent(K key,
     *              Function<? super K, ? extends V> remappingFunction)
     */

    // provide value for new key which is absent
    // using computeIfAbsent method
    //        map.computeIfAbsent("key5", k -> 2000 + 33000);
    //
    public Node cloneGraphRecursive(Node node) {
        return (node == null) ? null : cloneGraphRecursive(node, new HashMap<Integer, Node>);
    }

    public Node cloneGraphRecursive(Node node, HashMap<Integer, Node> nodeByVal) {
        if (nodeByVal.containsKey(node.val)) {
            return nodeByVal.get(node.val);
        }
        Node clone =  nodeByVal.computeIfAbsent(node.val, k -> new Node(node.val));
        for (Node neighbor:node.neighbors) {
            clone.neighbors.add(cloneGraphRecursive(neighbor, nodeByVal));
        }
        return clone;
    }

    /**
     * starting out at node1, the map won't have any record for it, so proceed to creating a clone and
     * adding an entry for it. then it'll look for its neighbors, none of which will have entries either,
     * so the function calls itself on each one of the neighbors. eventually you'll get so far into the
     * graph that one of the nodes will have entries for all its neighbors, whether say that's 10 recursive
     * calls deep clone10 will be returned, and added to neighbors for 9 until all of 9s neighbors have
     * entries in the map, back back back to looping over the neighbors of clone for node1, by which point
     * all the information will be available for clone1 to be a true root copy of the original graph.
     */


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
