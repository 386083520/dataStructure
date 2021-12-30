package BSTree;


public class BSTree<E extends Comparable> {
    private class Node {
        private E e;
        private Node left,right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;
    private int size;

    public BSTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        /*if(e.compareTo(node.e) == 0) {
            return;
        }
        if(e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        }
        if(e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }
        if(e.compareTo(node.e) < 0) {
            add(node.left, e);
        }else {
            add(node.right, e);
        }*/
        if(node == null) {
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }else if(e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }
}
