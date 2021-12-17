package array;

public class Array {
    private int[] arr;
    private int size;
    public Array(int capacity) {
        arr = new int[capacity];
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

    public void addLast(int e) {
        /*if(size == arr.length) {
            throw new IllegalArgumentException("添加失败，容量已满");
        }
        arr[size] = e;
        size++;*/
        add(size ,e);
    }

    public void addFirst(int e) {
        add(0 ,e);
    }

    public void add(int index, int e) {
        if(size == arr.length) {
            throw new IllegalArgumentException("添加失败，容量已满");
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

    public int get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("获取失败，index不合法");
        }
        return arr[index];
    }

    public void set(int index, int e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("设置失败，index不合法");
        }
        arr[index] = e;
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
