package stack;

import LinkedList.DummyLinkedList;

public class LinkedListStack<E> implements Stack<E>{
    DummyLinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new DummyLinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("top ");
        builder.append(linkedList.toString());
        builder.append(" tail");
        return builder.toString();
    }
}
