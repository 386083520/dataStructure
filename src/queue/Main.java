package queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        /*queue.dequeue();
        queue.dequeue();*/
        System.out.println(queue);
        queue.enqueue(11);
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getFront());
        System.out.println(queue);
    }
}
