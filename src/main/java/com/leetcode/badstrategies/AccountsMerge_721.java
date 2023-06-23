package com.leetcode.badstrategies;

import java.util.*;

/**
 * anki card addition: sublist (x, n) whatever
 * anki card addition, compareTo, comparable interface.
 *
 * here I think hashmap<key, treemap> might be the play here as well maybe?
 * oh hell no I'm seeing dfs in the solution headers this is a graph problem
 *
 * probably worth examining both disjoint sets/union find and dfs approaches here.
 */
public class AccountsMerge_721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        ArrayList<Node> entries = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            entries.add(new Node(accounts.get(i).get(0), accounts.get(i).subList(1, accounts.get(i).size())));
        }
        Collections.sort(entries);
        return null;
    }

    private class Node implements Comparable<Node> {
        public String name;
        public ArrayList<String> email;

        public Node() {};
        public Node(String name, List<String> email) {
            this.name = name;
            this.email = new ArrayList<>(email);
        }

        public Node(Node node) {
            this.email.addAll(node.email);
        }
        @Override
        public int compareTo(Node n1) {
            return this.name.compareTo(n1.name);
        }
    }

}
