package com.leetcode.accepted;

import com.leetcode.utils.Trie;

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
    public static boolean wordBreakbad(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word:wordDict) {
            trie.insert(word);
        }
        Trie curr = trie;
        String substring = "";
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            substring += c;
            if (curr.find(substring)) {
                substring = "";
                curr = trie;
                if (i == s.length() - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
