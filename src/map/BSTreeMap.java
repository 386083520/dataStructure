package map;

import java.util.LinkedList;
import java.util.Queue;

public class BSTreeMap<K extends Comparable ,V> implements Map<K, V>{
    private class Node {
        private K k;
        private V v;
        private Node left,right;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;
    private int size;

    public BSTreeMap() {
        this.root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K k, V v) {
        if(node == null) {
            size++;
            return new Node(k, v);
        }
        if(k.compareTo(node.k) < 0) {
            node.left = add(node.left, k, v);
        }else if(k.compareTo(node.k) > 0) {
            node.right = add(node.right, k, v);
        }else {
            node.v = v;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        return null; // TODO
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if(node == null) {
            throw new IllegalArgumentException(key + " 不存在");
        }
        node.v = newValue;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null: node.v;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    private Node getNode(Node node, K k) {
        if(node == null) {
            return null;
        }
        if(k.compareTo(node.k) == 0) {
            return node;
        }else if(k.compareTo(node.k) < 0) {
            return getNode(node.left, k);
        }else {
            return getNode(node.right, k);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            builder.append(node.k + "->" + node.v + " ");
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return builder.toString();
    }
}
