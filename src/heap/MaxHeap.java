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

    public E parent(int index) {
        if(index == 0) {
            throw new IllegalArgumentException("该索引不存在父亲节点");
        }
        return array.get((index - 1)/2);
    }

    public E leftChild(int index) {
        return array.get(index * 2 + 1);
    }

    public E rightChild(int index) {
        return array.get(index * 2 + 2);
    }


}
