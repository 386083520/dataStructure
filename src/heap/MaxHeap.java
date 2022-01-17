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
        shiftUp(array.getSize() - 1);
    }

    private void shiftUp(int index) {
        while (index > 0 && (array.get(index).compareTo(array.get(parent(index))) > 0)) {
            array.swap(index, parent(index));
            index = parent(index);
        }
    }

}
