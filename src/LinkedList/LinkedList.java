package LinkedList;

public class LinkedList<E> {
    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public Node() {
            this.e = null;
            this.next = null;
        }
    }

    private int size;
    private Node head;

    public LinkedList() {
        size = 0;
        head = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        Node node = new Node(e);
        node.next = head;
        head = node;
        size ++;
    }

    public void add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败，index不合法");
        }
        if(index == 0) {
            addFirst(e);
        }else {
            Node pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            Node node = new Node(e);
            node.next = pre.next;
            pre.next = node;
            size ++;
        }
    }
}
