package SegmentTree;

public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr ,Merger<E> merger) {
        this.merger = merger;
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if(l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int mid = l + (r - l)/2;
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        buildSegmentTree(leftChildIndex, l, mid);
        buildSegmentTree(rightChildIndex, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if(index < 0 || index >= data.length) {
            throw new IllegalArgumentException("index不合法");
        }
        return data[index];
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < tree.length; i++) {
            if(tree[i] != null) {
                builder.append(tree[i]);
            }else {
                builder.append("null");
            }
            if(i != tree.length-1) {
                builder.append("--");
            }else {
                builder.append("]");
            }
        }
        return builder.toString();
    }
}
