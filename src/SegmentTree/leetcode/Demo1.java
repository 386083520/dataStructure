package SegmentTree.leetcode;

import SegmentTree.Merger;
import SegmentTree.SegmentTree;

public class Demo1 {
    SegmentTree<Integer> segmentTree;
    public Demo1(int[] nums) {
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

    public int sumRange(int left, int right) {
        return segmentTree.query(left, right);
    }
}
