package SegmentTree.leetcode;

import SegmentTree.SegmentTree;
import SegmentTree.Merger;

public class Demo3 {
    SegmentTree<Integer> segmentTree;
    public Demo3(int[] nums) {
        Integer[] temp = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        segmentTree = new SegmentTree<Integer>(temp, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
    }

    public void update(int index, int val) {
        segmentTree.set(index, val);
    }

    public int sumRange(int left, int right) {
        return segmentTree.query(left, right);
    }
}
