package LinkedList;

public class DummyLinkedList<E> {
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
    private Node dummyHead;

    public DummyLinkedList() {
        size = 0;
        dummyHead = new Node(null, null);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {  // null->1->2->3->4
        add(0, e);
    }

    public void add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败，index不合法");
        }
        Node pre = dummyHead;// null->1->2->3->4
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node node = new Node(e);
        node.next = pre.next;
        pre.next = node;
        size ++;
    }
}
