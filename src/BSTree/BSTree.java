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

    public boolean contains(E e) {
        return contains(root, e);
    }
    private boolean contains(Node node, E e) {
        if(node == null) {
            return false;
        }
        if(e.compareTo(node.e) == 0) {
            return true;
        }else if(e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }else {
            return contains(node.right, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        buildBstString(root, 0, builder);
        return builder.toString();
    }

    private void buildBstString(Node node, int dept, StringBuilder builder) {
        if(node == null) {
            builder.append(buildDeptString(dept) + "NULL\n");
            return;
        }
        builder.append(buildDeptString(dept) + node.e + "\n");
        buildBstString(node.left, dept + 1, builder);
        buildBstString(node.right, dept + 1, builder);
    }

    private String buildDeptString(int dept) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < dept; i++) {
            builder.append("--");
        }
        return builder.toString();
    }
}
