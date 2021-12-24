package LinkedList;

public class Main {
    public static void main(String[] args) {
        DummyLinkedList linkedList = new DummyLinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
        }
        linkedList.add(3, 66);
        linkedList.set(3, 88);
        linkedList.remove(3);
        linkedList.remove(3);
        System.out.println(linkedList.contains(66));
        System.out.println(linkedList);
    }
}
