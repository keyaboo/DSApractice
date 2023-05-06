package com.leetcode.accepted;

import java.util.ArrayList;

/**
 * I know this isn't safe against null inputs. nvm 1 <= word.length
 *
 * it works, didn't get an impressive time score though. could probably do some hashing to make this go faster,
 * because the way this is written there's no way this is a 20 minute problem.
 */
public class ImplementTrie_208 {
    CharNode root;
    public ImplementTrie_208() {
        this.root = new CharNode(null);
    }
    // three scenarios: neighbor already exists
    public void insert(String word) {
        CharNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            Boolean isWord = (i == word.length() - 1);
            Character c = word.charAt(i);
            CharNode wordNode = new CharNode(c);
            CharNode trieNeighbor = null;
            for (CharNode neighbor:node.neighbors) {
                if (neighbor.letter == c) {
                    trieNeighbor = neighbor;
                    trieNeighbor.isWord = (trieNeighbor.isWord) ? true : isWord;
                }
            }
            if (trieNeighbor == null) {
                trieNeighbor = wordNode;
                trieNeighbor.isWord = (trieNeighbor.isWord) ? true : isWord;
                node.neighbors.add(trieNeighbor);
            }
            node = trieNeighbor;
        }
    }

    public boolean search(String word) {
        CharNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            CharNode trieNeighbor = null;
            for (CharNode neighbor:node.neighbors) {
                if (neighbor.letter == c) {
                    trieNeighbor = neighbor;
                }
            }
            if (trieNeighbor == null) return false;
            if (i == word.length() - 1) {
                if (!(trieNeighbor.isWord)) return false;
            }
            node = trieNeighbor;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        CharNode node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            CharNode trieNeighbor = null;
            for (CharNode neighbor:node.neighbors) {
                if (neighbor.letter == c) {
                    trieNeighbor = neighbor;
                }
            }
            if (trieNeighbor == null) return false;
            node = trieNeighbor;
        }

        return true;
    }

    private static class CharNode {
        public ArrayList<CharNode> neighbors;
        public Character letter;
        public boolean isWord;

        public CharNode(Character letter) {
            this.letter = letter;
            this.neighbors = new ArrayList<>();
        }

    }
}
