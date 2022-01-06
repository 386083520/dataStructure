package set;

public class Main {
    public static void main(String[] args) {
        int[] arr = genArr(100000, 100000);
        Set<Integer> set1 = new LinkedListSet<>();
        Set<Integer> set2 = new BSTreeSet<>();
        test(set1, arr);
        test(set2, arr);
    }

    public static void test(Set set, int[] arr) {
        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        long endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1000000000.0);
    }

    public static int[] genArr(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int)(Math.random()*max);
        }
        return arr;
    }
}
