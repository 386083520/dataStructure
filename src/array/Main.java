package array;

public class Main {
    public static void main(String[] args) {
        /*int[] arr1= new int[10];
        arr1[1] = 4;
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }*/
        Array array = new Array(10);
        for (int i = 0; i < 11; i++) {
            array.addLast(i);
        }
        array.removeLast();
        // array.removeLast();
        System.out.println(array);
    }
}
