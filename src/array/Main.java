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
        array.remove(2);
        array.removeElement(7);
        System.out.println(array);
    }
}
