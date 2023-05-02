package com.leetcode.badstrategies;

import java.util.*;

/**
 * I'm thinking perhaps some sort of tree where root is the most basic of prereqs, but having separate trees for
 * example 2 would suggest a possible way of doing course 0 and 1. The hierarchy, once established, cannot be
 * overwritten. dfs on the graph to find all courses that are not prereqs and what level they're on, subtract
 * that by numcourses, except there's both the possibility of separate trees and branching at any level.
 *
 * for each of the trees constructed, need to find total number of nodes with some dfs traversal. A hashmap
 * can be <key courseNum, val TreeNode>.
 *
 * nahh that's too complicated this is an array problem. also says all pairs of prereqs are unique.
 *
 * thinking doubly linked list or equiv with arraydeque. Perhaps an array of them.
 *
 * <><><> this finishes because prereqs have been cycled through one time, assign it to arraydeque progression
 *
 * ok I am a moron, example 2 or situations like it are the only way you can mess this up.
 *
 * 1) find out how to construct multiple graphs from edge data, conveniently numCourses provides enough
 * information to construct an adjacency matrix for a directed graph. If A -> B, and A has no in-degree info,
 * the column for A in the adjacency matrix will be filled with 0s, col B will have a 1 at row A.
 * 2) perform a topological sort
 * The algorithm of the topological sort goes like this:
 *
 *     Identify the node that has no in-degree(no incoming edges) and select that node as the source node of the graph
 *     Delete the source node with zero in-degree and also delete all its outgoing edges from the graph. Insert the deleted vertex in the result array.
 *     Update the in-degree of the adjacent nodes after deleting the outgoing edges
 *     Repeat step 1 to step 3 until the graph is empty
 *
 * I'm thinking if you made a hashtable that stored nodes integers as keys and their connected nodes as values.
 *
 * could also have a queue of courses, a hashset of lowercourse and a hashset called upperCourse.
 * loop again over numCourses, if it's in upperCourses skip it, if it's in lowerCourse refer to the HT what it's
 * connected to. LC A->(B->C)UC here for simplicity, I think I want to differ from the top sort in that I want to keep
 * moving things to lower. the check for a cycle can be if you're pulling a value from the map that's higher but
 * it's already in lower somehow.
 *
 * ok when actually writing this out, I don't think it's actually necessary to remove stuff from upper.
 *
 * ok, none of this graph stuff I mentioned above mattered at all.
 *
 * finding roots is tricky when the example case gives two BS ones, if you're starting in the middle of the graph
 * you may erroneously return false the way I have things set up here.
 *
 * what if I just made the hashtable doubly linked? an Integer array with [previous, next]
 *
 * fuck this looking at the answer.
 */
public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer[]> edges = new HashMap<>();
        HashSet<Integer> possibleRoot = new HashSet<>();
        HashSet<Integer> notRoot = new HashSet<>();
        for (int[] prereq:prerequisites) {
            if (!(edges.containsKey(prereq[0]))) {
                edges.put(prereq[0], new Integer[] { prereq[1], null} );
            } else {

            }
            if (!(edges.containsKey(prereq[1]))) {
                edges.put(prereq[1], new Integer[] { null, prereq[0]});
            } else {
                edges.get(prereq[1])[0] = prereq[1];
            }
            // [2, 1] [1, 0] gotta visualize this
            // 1 -> {null, 2} -> {0, 2}
            // 0 -> {null, 1}
        }
        HashSet<Integer> cleared = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (notRoot.contains(i))
                continue;
            int k = i;
            int v;
            while (edges.containsKey(k)) {
                cleared.add(k);
//                v = edges.get(k);
//                if (cleared.contains(v)) {
//                    return false;
//                }
//                k = v;
            }
            cleared.add(k); // adds the tail
        }
        return true;
    }


}
