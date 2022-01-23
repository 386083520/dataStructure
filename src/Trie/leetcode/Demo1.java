package Trie.leetcode;

import Trie.Trie;

import java.util.HashMap;
import java.util.Map;

public class Demo1 {
    private class Node {
        private Map<Character, Node> next;
        private boolean isWord;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }
    private Node root;
    public Demo1() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if(word.length() == index) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if(c!='.') {
            if(node.next.get(c) == null) {
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        }else {
            for (char nextChar: node.next.keySet()) {
                if(match(node.next.get(nextChar), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
