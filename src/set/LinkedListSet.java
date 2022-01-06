package set;

import LinkedList.DummyLinkedList;

public class LinkedListSet<E> implements Set<E>{
    private DummyLinkedList<E> linkedList;

    public LinkedListSet() {
        linkedList = new DummyLinkedList<>();
    }

    @Override
    public void add(E e) {
        if(!linkedList.contains(e)) {
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public boolean isEmpty(E e) {
        return linkedList.isEmpty();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }
}
