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
 * I feel like some sort of second loop is inevitable because the copy for the neighbor doesn't exist yet
 *
 * ok I really need to get in the habit of readying these functions anticipating nulls and other edge cases
 *
 * just gonna look at the solution, fix up whatever's wrong with this since it's hard to test. I imagine there's
 * some way of doing this that doesn't require two hashmaps, in fact having just one with value being a composite
 * class of integer neighbors and baby nodes could work, but custom classes suck.
 */
public class CloneGraph_133 {

    public Node cloneGraphBFS(Node node) {
        // adding ugly comments as a mark of cain for hitting submit without considering edge cases.
        if (node == null) {
            return null;
        } else if (node.neighbors.isEmpty()) {
            return new Node(node.val);
        }
        int head = node.val; // just for returning head of the original thing at the end.
        Queue<Node> traversal = new ArrayDeque<>();
        HashMap<Integer, List<Integer>> neighborAssociation = new HashMap<>();
        HashMap<Integer, Node> storedCopies = new HashMap<>();
        Set<Node> traversed = new HashSet<>();
        traversal.add(node);
        while (!traversal.isEmpty()) {
            node = traversal.poll();
            traversed.add(node);
            ArrayList<Integer> neighbors = new ArrayList<>();
            for (int i = 0; i < node.neighbors.size(); i++) {
                if (!(traversed.contains(node.neighbors.get(i)))) {
                    traversal.add(node.neighbors.get(i));
                    // sloppy of me to add more here this is only for the queue
                }
                neighbors.add(node.neighbors.get(i).val);
            }
            neighborAssociation.put(node.val, neighbors);
            storedCopies.put(node.val, new Node(node.val));
        }
        for (Integer key:storedCopies.keySet()) {
            ArrayList<Node> newNeighbors = new ArrayList<>();
            for (int i = 0; i < neighborAssociation.get(key).size(); i++) {
                newNeighbors.add(storedCopies.get(i));
            }
            storedCopies.put(key, new Node(key, newNeighbors));
        }
        // this got so big my curly braces got all messed up.
        return storedCopies.get(head);
    }

    /**
     * maybe create a generic graph utility class for instantiating with adjacency list inputs later.
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
