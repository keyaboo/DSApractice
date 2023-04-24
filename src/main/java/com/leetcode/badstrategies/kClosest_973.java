package com.leetcode.badstrategies;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * min heap problem, construct heap based on distances. create a private class for it?
 *
 * brute force would be to sort distances and return first k.
 *
 * seems I am getting the opposite results. I hate how I did this tbh going to look at the solution.
 *
 */
public class kClosest_973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> minHeap = new PriorityQueue<Point>();

        for (int i = 0; i < k; i++) {
            int x = points[i][0];
            int y = points[i][1];
            Point p = new Point(new int[] {x, y});
            minHeap.add(p);
        }

        for (int i = k; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            Point p = new Point(new int[] {x, y});
            if (minHeap.peek().distance < p.distance) {
                continue;
            } else {
                minHeap.poll();
                minHeap.add(p);
            }
        }
        Iterator iterator = minHeap.iterator();
        int[][] solution = new int[minHeap.size()][2];
        int counter = 0;
        while(iterator.hasNext()) {
            Point p = (Point) iterator.next();
            solution[counter][0] = p.address[0];
            solution[counter][1] = p.address[1];
            counter++;
        }
        return solution;

    }

    private static class Point implements Comparable<Point>{
        public int[] address;
        public Double distance;

        public Point(int[] point) {
            double norm = Math.sqrt(Math.pow(point[0],2) + Math.pow(point[1],2));
            address = new int[] {point[0], point[1]};
            distance = norm;
        }

        @Override
        public int compareTo(Point anotherPoint) {
            return  Double.compare(anotherPoint.distance, this.distance);
        }
    }

}
