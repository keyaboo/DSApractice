package com.leetcode.accepted;

import com.leetcode.utils.Trie;
import com.leetcode.utils.TrieNode;

import java.util.*;

/*
    seems like a trie problem - no not a trie problem
    have a dp bool array that determines whether at a given letter of the input string, the dictionary has a string
    terminating on the index character.
    use hashset to store wordDict
    loops similar to the partial subset equal sum except j starts from the left
 */
public class WordBreak_139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
        System.out.println(wordBreak(s, wordDict));
        System.out.println(wordBreakTrie(s, wordDict));
    }

    /*
    this is really crappy O(n^2), the faster ones do dfs with tries
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    /*
    could this be done with tries yes probably idk
    EDIT after submission of above: definitely could be done with tries and faster
     */
    public static boolean wordBreakTrie(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word:wordDict) {
            trie.insert(word);
        }
        boolean[] dp = new boolean[s.length()];
        boolean[] visited = new boolean[s.length()];
        return dfs(s, 0, trie.getRoot(), dp, visited);
    }

    private static boolean dfs(String s, int curr, TrieNode root, boolean[] dp, boolean[] visited) {
        if (curr == s.length()) {
            return true; // this is just the condition for the entire string s having the dictionary words be components,
            // a dp[s.length - 1] which is by default false would return for both methods if that weren't the case
        }
        if (visited[curr]) {
            return dp[curr];
        }

        TrieNode node = root;
        for (int i = curr; i < s.length(); i++) { // substrings always shorter than or eq to s, start at different places
            char c = s.charAt(i);
            if (!(node.getChildren().containsKey(c))) {
                break;
            } else {
                node = node.getChildren().get(c); // retrieve the next trienode since the character on the index is legitimate
                if (node.isEndOfWord() && dfs(s, i + 1, root, dp, visited)) {
                    dp[curr] = true;
                    break;
                }
            }
        }
        visited[curr] = true;
        return dp[curr];
    }
}
