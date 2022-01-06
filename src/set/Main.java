package set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedListSet<>();
        int[] arr = {1,2,2,3,3,3,4,4,4,4,5};
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        System.out.println(set.getSize());
    }
}
