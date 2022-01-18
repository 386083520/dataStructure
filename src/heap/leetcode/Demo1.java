package heap.leetcode;

import java.util.*;

public class Demo1 { // 347-前k个高频元素
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for(int key: map.keySet()) {
            if(queue.size() < k) {
                queue.add(key);
            }else if(map.get(queue.peek()) < map.get(key)) {
                queue.remove();
                queue.add(key);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.remove();
        }
        return res;
    }
}
