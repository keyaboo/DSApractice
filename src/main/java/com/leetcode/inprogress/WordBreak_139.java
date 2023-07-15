package com.leetcode.inprogress;

import com.leetcode.utils.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    seems like a trie problem - no not a trie problem
    have a dp bool array that determines whether at a given letter of the input string, the dictionary has a terminating
    
 */
public class WordBreak_139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        return false;
    }


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
