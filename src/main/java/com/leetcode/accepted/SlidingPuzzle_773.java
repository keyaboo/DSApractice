package com.leetcode.accepted;

import java.util.*;

/*
this is similar to the N^2 puzzle on the simpl test. to get the empty block from position 0,0 to
n-1,n-1 took 2 (n-1) steps. for this problem 1-3 must be sequentially connected in a sequential arrangement.
I was thinking that would take care of 4 and 5 but it doesn't as shown in example 2. if the sequence
is L-> R, 4 and 5 need to also be arranged L->R. I think the first move is going to correctly place
one of them and you'd just do a circle around. You look at the grid position of which block should be there,
then swap it with the block in whatever direction it's coming from. This means we have a criteria that
while the block isn't in position 6, look for the block nearby that ought to go there. At the end
confirm that the board looks as it should.

that isn't it, this is a bfs problem. nodes are the puzzle boards are edges are if two puzzle boards
can be transformed into one another with one move.


yes to visited, with array represnted as a string. Ok mostly just copied the solution but there are some
interesting things about this problem to talk about.

the steps increases seemingly independently of the board position which at first glance seemed like an
odd choice. But bfs works on a per-level basis, so it explores all states reachable in one move, then
in two moves. So the board position does matter because you won't be adding to the queue if it's a seen
configuration. Oh I know why I was confused by the steps++ possibly overcounting I didn't have a layer
specific while loop at all.


 */
public class SlidingPuzzle_773 {
    public int slidingPuzzle(int[][] board) {
        int[][] directions = new int[][] {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}}; // get this right.
        Set<String> visited = new HashSet<>();
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        visited.add(sb.toString());
        Queue<String> queue = new LinkedList<>();
        queue.add(sb.toString());
        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String state = queue.poll();
                if (state.equals(target)) {
                    return steps;
                }
                int emptyPosition = state.indexOf('0');
                for (int newTile : directions[emptyPosition]) {
                    String nextState = swap(state, emptyPosition, newTile); // comes first before increment (IGNORE)
                    if (visited.contains(nextState)) continue; // this is part 1 of the other important ordering
                    visited.add(nextState);
                    queue.add(nextState); // this is part 2
                }
            }
            steps++; // comes second
        }
        return -1;
    }

    // swap method
    private String swap(String board, int i, int j) {
        StringBuilder sb = new StringBuilder(board);
        sb.setCharAt(i, board.charAt(j));
        sb.setCharAt(j, board.charAt(i));
        return sb.toString();
    }

}
