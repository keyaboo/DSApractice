package com.leetcode.inprogress;

import com.leetcode.utils.Trie;

import java.util.List;

/*
    seems like a trie problem
 */
public class WordBreak_139 {
    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word:wordDict) {
            trie.insert(word);
        }
        return false;
    }
}
