package heap;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int i = 0; i < 100; i++) {
            maxHeap.add(new Random().nextInt(100));
        }
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.removeMax());
        }
    }
}
