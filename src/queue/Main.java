package queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getFront());
        System.out.println(queue);
    }
}
