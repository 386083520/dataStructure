package heap;

import array.Array;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> array;

    public MaxHeap(int capacity) {
        array = new Array<>(capacity);
    }
    public MaxHeap() {
        array = new Array<>();
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int parent(int index) {
        if(index == 0) {
            throw new IllegalArgumentException("该索引不存在父亲节点");
        }
        return (index - 1)/2;
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        array.addLast(e);
        siftUp(array.getSize() - 1);
    }

    private void siftUp(int index) {
        while (index > 0 && (array.get(index).compareTo(array.get(parent(index))) > 0)) {
            array.swap(index, parent(index));
            index = parent(index);
        }
    }

    private E getMax() {
        if(array.getSize() == 0) {
            throw new IllegalArgumentException("堆为空");
        }
        return array.get(0);
    }

    public E removeMax() {
        E e = getMax();
        array.swap(0, array.getSize() - 1);
        array.removeLast();
        siftDown(0);
        return e;
    }

    private void siftDown(int index) {
        while (leftChild(index) < array.getSize()) {
            int i = leftChild(index);
            if(i+1 < array.getSize() && (array.get(i).compareTo(array.get(i+1)) < 0)) {
                i = rightChild(index);
            }
            if(array.get(index).compareTo(array.get(i)) >= 0) {
                break;
            }
            array.swap(index, i);
            index = i;
        }
    }

    public E replace(E e) {
        E res = getMax();
        array.set(0, e);
        siftDown(0);
        return res;
    }

}
