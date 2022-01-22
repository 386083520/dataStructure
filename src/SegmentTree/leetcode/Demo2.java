package SegmentTree.leetcode;

public class Demo2 {
    int[] sum; // sum[i] -> [0, i-1]
    public Demo2(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {   // [1,2,3,4,5] [0,1,3,6,10,15]
        return sum[right + 1] - sum[left];
    }
}
