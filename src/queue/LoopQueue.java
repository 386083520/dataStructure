package queue;

public class LoopQueue<E> implements Queue<E>{
    private E[] array;
    private int front,tail,size;

    public LoopQueue(int capacity) {
        array = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return array.length - 1;
    }


    @Override
    public void enqueue(E e) {
        if((tail + 1) % array.length == front) {
            resize(2 * getCapacity());
        }
        array[tail] = e;
        tail = (tail + 1) % array.length;
        size ++;
    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getSize() {
        return size;
    }

    private void resize(int capacity) {
        E[] newArray = (E[])new Object[capacity + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[(i + front) % array.length];
        }
        array = newArray;
        front = 0;
        tail = size;
    }
}
