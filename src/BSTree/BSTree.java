package BSTree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public void preOrderNR() {
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            System.out.println(node.e);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.e);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public E min() {
        if(size == 0) {
            throw new IllegalArgumentException("树为空，无法获取最小值");
        }
        return min(root).e;
    }
    private Node min(Node node) {
        if(node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public E max() {
        if(size == 0) {
            throw new IllegalArgumentException("树为空，无法获取最大值");
        }
        return max(root).e;
    }
    private Node max(Node node) {
        if(node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public void remove(E e) {
        // TODO
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
