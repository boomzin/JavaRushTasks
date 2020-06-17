package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    private List<Entry<String>> tree = new ArrayList<>();
    Entry<String> root;

    public CustomTree() {
        this.root = new Entry<>("root");
        tree.add(root);
    }

    @Override
    public boolean remove(Object o) {

        if (o instanceof String) {
            for (int i = 1; i < tree.size(); i++) {
                if (tree.get(i).elementName.equals(o)) {
                    if (!(tree.get(i).rightChild == null)) {
                        remove(tree.get(i).rightChild.elementName);
                    }
                    if (!(tree.get(i).leftChild == null)) {
                        remove(tree.get(i).leftChild.elementName);
                    }
                    tree.remove(i);
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }


        return true;
    }

    @Override
    public boolean add(String s) {
        Entry newParent;
        Entry newChild = new Entry(s);
        boolean isAbleToAdd = false;
        for (int i = 1; i < tree.size(); i++) {
            if (tree.get(i).isAvailableToAddChildren()) {
                isAbleToAdd = true;
            }
        }
        if (!isAbleToAdd) {
            for (int i = tree.size() - 1; i >= tree.size() - ((tree.size() - 1) / 2 + 1) ; i--) {
                tree.get(i).availableToAddLeftChildren = true;
                tree.get(i).availableToAddRightChildren = true;
            }
        }


        for (int i = 0; i < tree.size(); i++) {
            if ((newParent = tree.get(i)).isAvailableToAddChildren()) {
                if (newParent.availableToAddLeftChildren & newParent.availableToAddRightChildren) {
                    newChild.parent = newParent;
                    newParent.leftChild = newChild;
                    newParent.availableToAddLeftChildren = false;
                    tree.add(newChild);
                    return true;
                }else if (newParent.availableToAddRightChildren) {
                    newChild.parent = newParent;
                    newParent.rightChild = newChild;
                    newParent.availableToAddRightChildren = false;
                    tree.add(newChild);
                    return true;
                }
            }
        }
        return false;
    }

    public String getParent(String s) {
        for (int i = 0; i < tree.size(); i++) {
            if (tree.get(i).elementName.equals(s)) {
                return tree.get(i).parent.elementName;
            }
        }
        return null;
    }

    @Override
    public void replaceAll(UnaryOperator<String> operator) {

    }

    @Override
    public void sort(Comparator<? super String> c) {

    }

    @Override
    public void forEach(Consumer<? super String> action) {

    }

    @Override
    public Spliterator<String> spliterator() {
        return null;
    }

    @Override
    public Stream<String> stream() {
        return null;
    }

    @Override
    public Stream<String> parallelStream() {
        return null;
    }

    @Override
    public int size() {
        return tree.size() - 1;
    }

    @Override
    public boolean removeIf(Predicate<? super String> filter) {
        return false;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }
    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;
        public Entry(String name) {
            this.elementName = name;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return this.availableToAddLeftChildren || this.availableToAddRightChildren;
        }
    }

}
