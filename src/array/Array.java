package array;

public class Array<E> {
    private E[] arr;
    private int size;
    public Array(int capacity) {
        arr = (E[])new Object[capacity];
        size = 0;
    }
    public Array() {
        this(10);
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int getCapacity() {
        return arr.length;
    }

    public void addLast(E e) {
        /*if(size == arr.length) {
            throw new IllegalArgumentException("添加失败，容量已满");
        }
        arr[size] = e;
        size++;*/
        add(size ,e);
    }

    public void addFirst(E e) {
        add(0 ,e);
    }

    public void add(int index, E e) {
        if(size == arr.length) {
            // throw new IllegalArgumentException("添加失败，容量已满");
            resize(getCapacity() * 2);
        }
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败，index不合法");
        }
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = e;
        size++;
    }

    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("获取失败，index不合法");
        }
        return arr[index];
    }

    public void set(int index, E e) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("设置失败，index不合法");
        }
        arr[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("删除失败，index不合法");
        }
        E el = arr[index];
        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        size --;
        arr[size] = null;
        if(size == getCapacity()/2) {
            resize(getCapacity()/2);
        }
        return el;
    }
    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
    }

    private void resize(int capacity) {
        E[] newArr = (E[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("容量：%d, 大小：%d\n", arr.length, size));
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(arr[i]);
            if(i != size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
