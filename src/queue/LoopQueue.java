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
        if(isEmpty()) {
            throw new IllegalArgumentException("队列为空，无法获取");
        }
        E e = array[front];
        array[front] = null;
        front = (front + 1)% (array.length);
        size--;
        if(size == getCapacity()/4) {
            resize(getCapacity()/2);
        }
        return e;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("队列为空，无法获取");
        }
        return array[front];
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
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(i + front) % array.length];
        }
        array = newArray;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("LoopQueue: 容量：%d, 大小：%d\n", getCapacity(), size));
        stringBuilder.append("front [");
        for (int i = front; i != tail; i = (i+1)%array.length) {
            stringBuilder.append(array[i]);
            if((i%array.length) != (tail - 1)) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }
}
