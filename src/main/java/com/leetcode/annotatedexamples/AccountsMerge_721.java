package com.leetcode.annotatedexamples;

import java.util.*;

/**
 * first the union-find, two operations
 * find: determine which subset a particular element is in.
 * union: join two subsets into a single subset
 *
 *
 */
public class AccountsMerge_721 {
    public List<List<String>> accountsMerged(List<List<String>> accounts) {
        return null;
    }

    public List<List<String>> accountsMergedDFS(List<List<String>> accounts) {
        //<email node(key being all email strings), neighbor nodes (set of all other associated emails from an account node)>
        //<email string key, username string value, what you have to get back to eventually>
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> owners = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> elements = accounts.get(i);
            String name = elements.get(0);
            Set<String> neighbors = new HashSet<>(elements);
            neighbors.remove(name);
            for (int j = 0; j < elements.size(); j++) {
                String email = elements.get(j);
                if (!(graph.containsKey(email))) {
                    graph.put(email, new HashSet<>());
                }
                graph.get(email).addAll(neighbors);
                // so if there's already an email/neighbors set pairing from a previous element, all new
                // neighbors from a different element will go into the set, creating associations between the
                // different elements
                owners.put(email, name);
                // just so we can get back to "Joe" when we start finding out what there is to know about joe smith
            }
        }
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        // the dfs loop is by the owner map keys, having the owner put after the graph put in the inner loop
        // above makes what's being done harder to understand, I'll leave it as is to remember it though.
        for (String email: owners.keySet()) {
            if (!visited.contains(email)) {
                List<String> result = new ArrayList<>();
                dfs(graph, result, visited, email);
                // result will have of Joe's emails now even if there they were split up under different elements.
                Collections.sort(result);
                result.add(0, owners.get(email)); // this is just so the thing returned is the format it came in
                // <"Joe", "joe.smith@aol.com", "joesmith82@gmail.com">
                res.add(result);
            }
        }
        return res;
    }

    public static void dfs(Map<String, Set<String>> graph, List<String> list, Set<String> visited, String email) {
        list.add(email);
        visited.add(email);
        for (String neighbor: graph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, list, visited, neighbor);
            }
        }
    }

}
