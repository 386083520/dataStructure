package stack;

public interface Stack<E> {
    boolean isEmpty();
    E peek();
    E pop();
    void push(E e);
}
