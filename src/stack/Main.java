package stack;

public class Main {
    public static void main(String[] args) { // 1->2->3->4 -> 5
        // ArrayStack stack = new ArrayStack();
        Stack stack = new LinkedListStack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
