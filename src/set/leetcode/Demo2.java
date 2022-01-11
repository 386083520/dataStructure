package set.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Demo2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set set = new TreeSet();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        List list = new ArrayList();
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])) {
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = (int) list.get(i);
        }
        return arr;
    }
}
