package array;

public class Main {
    public static void main(String[] args) {
        /*int[] arr1= new int[10];
        arr1[1] = 4;
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }*/
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        array.add(3, 33);
        array.addFirst(11);
        array.set(0, 13);
        System.out.println(array);
        System.out.println(array.find(33));
        System.out.println(array.contains(6));
        System.out.println(array.contains(61));
    }
}
