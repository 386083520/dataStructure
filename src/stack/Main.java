package stack;

public class Main {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
