package com.leetcode.utils;

import java.util.HashMap;
import java.util.Map;

/*
    every node except root stores one character or digit
 */
public class TrieNode {
    private HashMap<Character, TrieNode> children;
    private String content;
    private boolean isWord;

    public TrieNode() {

    }

    public HashMap<Character, TrieNode> getChildren() {
        return this.children;
    }

    public void setEndOfWord(boolean isWord) {
        this.isWord = isWord;
    }

    public boolean isEndOfWord() {
        return this.isWord;
    }
}
