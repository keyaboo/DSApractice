package com.leetcode.inprogress;

import java.util.LinkedList;
import java.util.Queue;

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
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adjMatrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses]; // degree, essentially
        for (int[] prerequisite:prerequisites) {
            adjMatrix[prerequisite[1]][prerequisite[0]] = 1; // row comes first, column second
            indegree[prerequisite[1]] = prerequisite[0];
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
