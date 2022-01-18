package PriorityQueue;

public interface PriorityQueue<E> {
    void enqueue(E e);
    E dequeue();
    E getFront();
    boolean isEmpty();
}
