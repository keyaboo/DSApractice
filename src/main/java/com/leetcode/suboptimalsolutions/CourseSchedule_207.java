package com.leetcode.suboptimalsolutions;

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
    oh you don't know where the deletes are happening

    I misunderstood what the indegree array was designed for, it just tells you how many indegrees there are
    not where they're coming from.
    there's no reason to make the queue an int[], can just refer to the row from adjmatrix directly

    note: this was slow as shit because I looped over every course in the matrix, could easily have used an arraylist
    to accomplish the same thing, was thinking looping over arrays was faster than vectors, but there's no reason
    to preserve the full size really.
 */
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[][] adjMatrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for (int[] prereq:prerequisites) {
            adjMatrix[prereq[1]][prereq[0]] = 1;
            indegree[prereq[0]]++;
        }

        int count = numCourses;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if ((indegree[i] == 0)) {
                queue.add(i); // add any row without an indegree to the queue first
                // if you get a situation like example 2 where every course has an indegree, skip the while loop entirely and return false
                count--;
            }
        }

        while (queue.size() != 0) {
            int courseNum = queue.poll();
            int[] course = adjMatrix[courseNum];
            for (int i = 0; i < numCourses; i++) {
                if (course[i] == 1) {
                    indegree[i]--;
                    if (indegree[i] == 0) { // for branching prereqs, don't add the later course until you've encountered all prereqs in the queue
                        queue.add(i);
                        count--; // also don't count until they're all gone.
                    }

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
