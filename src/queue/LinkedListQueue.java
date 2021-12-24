package queue;


public class LinkedListQueue<E> implements Queue<E>{
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
    private Node tail;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        Node node = new Node(e);
        if(tail == null) {
            tail = node;
            head = node;
        }else {
            tail.next = node;
            tail = node;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("出队失败，队列为空");
        }
        Node returnNode = head;
        head = head.next;
        returnNode.next = null;
        if(head == null) {
            tail = null;
        }
        size --;
        return returnNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("查看失败，队列为空");
        }
        return head.e;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Queue: front ");
        Node cur = head;
        while (cur != null){
            builder.append(cur.e + "->");
            cur = cur.next;
        }
        builder.append("Null tail");
        return builder.toString();
    }
}
