package PriorityQueue;

import heap.MaxHeap;

public class HeapPriorityQueue<E extends Comparable<E>> implements PriorityQueue<E>{
    MaxHeap<E> maxHeap;

    public HeapPriorityQueue(MaxHeap<E> maxHeap) {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.removeMax();
    }

    @Override
    public E getFront() {
        return maxHeap.getMax();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
