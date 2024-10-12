package com.leetcode.inprogress;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
    First find the order of arrival for each friend (times[i] corresponds to friend[i]) by sorting
    on the first term (times[i][0]). Create two priority queues, one is a min heap to keep track of
    departure time, the heapify process ensures that the most imminent departure is at the front
    of the queue. The availablechairs is another min heap priorityqueue based
    on the natural ordering of integers. Since the loop is over friends rather than events, you'd
    check whether a friend's starting time exceeds or is equal to the end time of whatever the
    departuretime queue has at the front in order to see which chairs are available.
 */
public class NumberSmallestUnoccupied_1942 {
    public int smallestChair(int[][] times, int targetFriend) {
        Integer[] index = new Integer[times.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) ->
        { return times[a][0] - times[b][0]; }
        );

        PriorityQueue<int[]> departureTimes = new PriorityQueue<>((a, b) ->
        {return a[0] - b[0];}
        );

        int chair = 0;

        Queue<Integer> availableChairs = new PriorityQueue<>();

        for (int i = 0; i < index.length; i++) {
            int friend = index[i];
            int friendStart = times[friend][0];
            int friendDeparture = times[friend][1];
            int open = Integer.MAX_VALUE;

            while (!departureTimes.isEmpty() && (friendStart >= departureTimes.peek()[0])) {
                availableChairs.add(departureTimes.poll()[1]);
            }

            if (availableChairs.isEmpty()) {
                open = chair++;
            } else {
                open = availableChairs.poll();
            }
            departureTimes.add(new int[] {friendDeparture, open});

            if (targetFriend == friend) {
                return open;
            }
        }

        return Integer.MIN_VALUE;
    }

}
