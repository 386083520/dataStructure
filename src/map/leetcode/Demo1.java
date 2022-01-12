package map.leetcode;

import java.util.*;

public class Demo1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            if(!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            }else {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }
        }
        List list = new ArrayList();
        for (int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i])) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
                if(map.get(nums2[i]) == 0) {
                    map.remove(nums2[i]);
                }
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = (int) list.get(i);
        }
        return arr;
    }
}
