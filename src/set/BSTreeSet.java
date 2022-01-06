package set;

import BSTree.BSTree;

public class BSTreeSet<E extends Comparable> implements Set<E>{
    private BSTree<E> bsTree;

    public BSTreeSet() {
        bsTree = new BSTree<E>();
    }

    @Override
    public void add(E e) {
        bsTree.add(e);
    }

    @Override
    public void remove(E e) {
        bsTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bsTree.contains(e);
    }

    @Override
    public boolean isEmpty(E e) {
        return bsTree.isEmpty();
    }

    @Override
    public int getSize() {
        return bsTree.getSize();
    }
}
