package queue;

import java.util.Random;

public class Main {
    private static double test(Queue<Integer> queue, int count) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            Random random = new Random();
            queue.enqueue(random.nextInt(1000));
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000;
    }
    public static void main(String[] args) {
        int time = 100000;
        Queue<Integer> loopQueue = new LoopQueue<>();
        System.out.println("loopQueue:" + test(loopQueue, time));
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println("arrayQueue:" + test(arrayQueue, time));
        Queue<Integer> linkedListQueue = new LinkedListQueue<>();
        System.out.println("linkedListQueue:" + test(linkedListQueue, time));
        /*Queue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            linkedListQueue.enqueue(i);
        }
        linkedListQueue.dequeue();
        System.out.println(linkedListQueue.getFront());
        System.out.println(linkedListQueue);*/
    }
}
