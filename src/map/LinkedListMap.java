package map;

public class LinkedListMap<K, V> implements Map<K,V>{
    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this.key = key;
            this.value = null;
            this.next = null;
        }

        public Node() {
            this.key = null;
            this.value = null;
            this.next = null;
        }
    }

    private int size;
    private Node dummyHead;

    public LinkedListMap() {
        size = 0;
        dummyHead = new Node();
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if(pre.next.key.equals(key)) {
                break;
            }
            pre = pre.next;
        }
        if(pre.next != null) {
            Node cur = pre.next;
            pre.next = cur.next;
            cur.next = null;
            size--;
            return cur.value;
        }
        return null;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node == null) {
            throw new IllegalArgumentException(key + " 不存在");
        }
        node.value = newValue;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key)!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null: node.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if(cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node cur  = dummyHead.next;
        while (cur != null) {
            builder.append(cur.key + "->" + cur.value + " ");
            cur = cur.next;
        }
        return builder.toString();
    }
}
