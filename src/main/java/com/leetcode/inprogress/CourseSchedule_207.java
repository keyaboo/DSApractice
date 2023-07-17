package com.leetcode.inprogress;

import java.util.*;

/**
 * finding cycles in graphs with BFS.
 * initially load up the queue with beginner courses
 * loop through the adjacency matrix of a beginner course to find the successor course, referring to the
 * successor array to find the corresponding vector of successor course.
 *
 * no I'm an idiot you're trying to find tails first
 *
 * kahn's algorithm of topological sorting:
 * https://www.interviewkickstart.com/learn/kahns-algorithm-topological-sorting
 *
 * fails the test case of 1 course with an empty prerequisites matrix
 *
 */
public class CourseSchedule_207 {
/*
    so I guess you can have a [3,1],[3,2] situation which is where my test case failed.
    map<int,int> a poor indegree data structure then? tried map<int, list<int>> and it failed elsewhere on
    [[1,0],[1,2],[0,1]]
 */
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[][] adjMatrix = new int[numCourses][numCourses];
        HashMap<Integer,List<Integer>> indegree = new HashMap<>();
        for (int[] prereq:prerequisites) {
            adjMatrix[prereq[1]][prereq[0]] = 1;
            if (indegree.containsKey(prereq[0])) { // this is my own little spin on branching prereqs
                List<Integer> pres = indegree.get(prereq[0]);
                pres.add(prereq[1]);
            } else {
                indegree.put(prereq[0], new ArrayList<>(Arrays.asList(prereq[1])));
            }
        }

        int count = numCourses;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!(indegree.containsKey(i))) {
                queue.add(adjMatrix[i]); // add any row without an indegree to the queue first
                // if you get a situation like example 2 where every course has an indegree, skip the while loop entirely and return false
                count--;
            }
        }

        while (queue.size() != 0) {
            int[] course = queue.poll(); // generic course, a queue/while loop object only, no modifying values
            for (int i = 0; i < numCourses; i++) {
                if (course[i] == 1) { // consult indegree to determine which row to delete the '1' from
                    List<Integer> pres = indegree.get(i);
                    for (int j = 0; j < pres.size(); j++) {
                        int pre = pres.get(j);
                        adjMatrix[pre][i]--; // have to remove to avoid infinite loops in case we return to a course's row via a cycle
                    }
                    queue.add(adjMatrix[i]);
                    count--;
                }
            }
        }

        return count == 0;
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adjMatrix = new int[numCourses][numCourses]; // accessing adjMatrix[3], we get a column array with outdegree info, loop over
        // adjmatrix[3] to find the fifth element is a '1', adjmatrix[3][5] == 1. if the array adjMatrix[5] is full of zeroes, the
        // chain is only 1 in length. [5, 3] means 3 -> 5, adjmatrix[p1][p0] == 1
        int[] indegree = new int[numCourses]; // in degree is the 'connected to' quantity, [0, 1] data means 1 -> 0, take c1 before c0, indegree[p0] = p1
        for (int[] prerequisite:prerequisites) {
            adjMatrix[prerequisite[1]][prerequisite[0]] = 1; // row comes first, column second. the column arrays are used in the bfs
            // [2, 1] and [4, 1] both have 1 as prereq, indegree[2] = 1, indegree[4] = 1, indegree[p0] = p1
            // what's annoying is that for [2, 1] [2, 0] cannot check that an override is happening so easily
            // there's a conflation between 0 the default indegree val and 0 the course, this might actually be my problem gonna rewrite
            indegree[prerequisite[0]] = prerequisite[1];
        }
        int count = numCourses; // count being compared to numCourses is the criteria by which we return true
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                count--;
                queue.add(adjMatrix[i]); // adds a row to the queue
            }
        }
        while(queue.size() != 0) {
            int[] beginning = queue.poll();
            for (int i = 0; i < beginning.length; i++) {
                if (beginning[i] == 1) {
                    beginning[i]--;
                    int successorIndex = i;
                    int[] successor = adjMatrix[indegree[successorIndex]];
                    queue.add(successor);
                }
            }
            count--; // this is different and worth remembering, increment count with the poll, not
            // when a successor is found within the for loop.
        }


        return count == 0;
    }
}
