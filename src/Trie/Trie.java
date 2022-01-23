package Trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
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
    private int size;
    private Node root;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }
}
