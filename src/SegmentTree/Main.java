package SegmentTree;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {4,6,1,8,3,7,2,11,25};
        SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(arr, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(segmentTree.toString());
    }
}
