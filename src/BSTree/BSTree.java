package BSTree;


public class BSTree<E extends Comparable> {
    private class Node {
        private E e;
        private Node left,right;
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
}
