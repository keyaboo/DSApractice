package com.leetcode.inprogress;

import java.util.*;

/**
 * this is my first graph traversal problem. For intiial traversal, could store all edges in
 * https://stackoverflow.com/questions/3287003/three-ways-to-store-a-graph-in-memory-advantages-and-disadvantages
 * https://stackoverflow.com/questions/5493474/graph-implementation-c/5493656#5493656
 *
 *
 *
 * ok order of what has to be done here
 * node should be loaded onto the queue
 * curr should be reassigned to node
 * how to progress both curr and node though - another set of sets and queues?
 *
 * helpful to remember that the neighbors are just pointers
 *
 * (X Y1 Y2)
 * curr becomes this thing. hmmm
 * (Y1 X1 X2) node then becomes this thing
 *
 *
 *         Node curr = null;
 *         Node head = new Node(-1, new ArrayList<>(Arrays.asList(curr)));
 *
 * well this was a stupid idea.
 *
 * by clone I'm pretty sure they mean just work with the values.
 *
 * that means curr could start out with null neighbors using the basic bitch val constructor, and information
 * about adjacency could be steadily be drip fed back to curr while it's being worked on. since all the node.val
 * are unique for each node, could make a hashtable with key: node.val, value(redundant lol): ArrayList<Integer> neighbors
 * so if node progressed 1->3, copy wouldn't actually get that information until it gets to 3
 *
 * hmm no they both need to know they're connected to one another.
 *
 */
public class CloneGraph_133 {

    public Node cloneGraphBFS(Node node) {
        Node curr = node;
        Node head = new Node(-1, new ArrayList<>(Arrays.asList(curr)));
        Queue<Node> traversal = new ArrayDeque<>();
        Queue<Node> traversalCopy = new ArrayDeque<>();
        Set<Node> traversed = new HashSet<>();
        traversal.add(node);
        traversed.add(node);
        while (!traversal.isEmpty()) {
            node = traversal.poll();
            traversed.add(node);
            for (int i = 0; i < node.neighbors.size(); i++) {
                if (!traversed.contains(node.neighbors.get(i)))
                traversal.add(node.neighbors.get(i));
            }
            curr = new Node(node.val, (ArrayList<Node>) node.neighbors);
        }
        return head.neighbors.get(0);

    }

    /**
     * maybe create a generic graph utility class sometime later.
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
