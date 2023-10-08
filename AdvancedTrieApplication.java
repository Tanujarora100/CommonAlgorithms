package Trie;

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWordStructure {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;
        char data;

        public TrieNode(char c) {
            this.data = c;
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "children=" + children +
                    ", isEndOfWord=" + isEndOfWord +
                    ", data=" + data +
                    '}';
        }
    }

    TrieNode root;

    public DesignAddAndSearchWordStructure() {
        root = new TrieNode('/');
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode(c));
            }
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;

    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode curr) {
        if (index >= word.length())
            return curr.isEndOfWord;
        char ch = word.charAt(index);
        if (ch != '.') {
            if (!curr.children.containsKey(ch))
                return false;
            else {
                return dfs(word, index + 1, curr.children.get(ch));
            }
        } else {
            for (TrieNode child : curr.children.values()) {
                if (dfs(word, index + 1, child))
                    return true;
            }
        }
        return false;
    }
}
