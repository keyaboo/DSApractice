package com.leetcode.inprogress;

import java.util.HashMap;
import java.util.List;

/**
 * can have a hashmaps with key of char prefix, and node corresponding to it?
 * my existing treenode implementation isn't great for this.
 *
 */
public class ImplementTrie_208 {

    private static class Trie {
        public HashMap<Character, Node> prefixByChar;

        public Trie() {
            prefixByChar = new HashMap<>();
        }

        // make sure to account for word being null
        public void insert(String word){
            Node prefix = null;
            if (word == null) {
                return;
            } else if (prefixByChar.containsKey(word.charAt(0))) {
                prefix = prefixByChar.get(word.charAt(0));
            } else {
                prefixByChar.computeIfAbsent(word.charAt(0), k -> new Node(word.charAt(0), null));
            }
            

        }

        public boolean search(String word){
            return true;
        }

        public boolean startsWith(String prefix) {
            return true;
        }
    }

    private static class Node {
        public Character character;
        public List<Node> children;

        public Node(Character character, List<Node> children) {
            this.character = character;
            this.children = children;
        }

    }



}
