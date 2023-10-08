package Trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CreateTrie {
    static class TrieNode {
        Map<Character, TrieNode> children;
        char c;
        boolean isTheLastCharacterOfWord;

        public TrieNode(char c) {
            this.children = new HashMap<>();
            this.isTheLastCharacterOfWord = false;
            this.c = c;
        }

        public TrieNode() {

        }


        @Override
        public String toString() {
            return "TrieNode{" +
                    "children=" + children +
                    ", c=" + c +
                    ", isTheLastCharacterOfWord=" + isTheLastCharacterOfWord +
                    '}';
        }
    }

    static TrieNode root;

    CreateTrie() {
        root = new TrieNode('/');
    }


    //Inserts a word into the trie

    public static void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c))
                curr.children.put(c, new TrieNode(c));
            curr = curr.children.get(c);
        }
        curr.isTheLastCharacterOfWord = true;

    }


    //Returns if the word is in the trie

    public static boolean search(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.children.containsKey(ch))
                return false;
            curr = curr.children.get(ch);

        }
        return curr.isTheLastCharacterOfWord;

    }


    //Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c))
                return false;
            curr = curr.children.get(c);
        }
        return true;

    }

}
