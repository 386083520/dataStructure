package BSTree;

public class Main {
    public static void main(String[] args) {
        BSTree<Integer> bsTree = new BSTree<Integer>();
        int[] arr = {7,3,9,1,8,4};
        for (int i = 0; i < arr.length; i++) {
            bsTree.add(arr[i]);
        }
        System.out.println(bsTree);
        bsTree.preOrder();
        System.out.println();
        bsTree.inOrder();
        System.out.println();
        bsTree.postOrder();
    }
}
