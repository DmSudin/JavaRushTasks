package com.javarush.task.task20.task2028;
import java.io.Serializable;
import java.util.*;

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry root;

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) throw new UnsupportedOperationException();
        String s = (String) o;
        Entry item = list.get(list.indexOf(new Entry(s)));
        Entry parent = item.parent;

        // открепляемся от родительского элемента
        if (item.equals(parent.leftChild)) {
            parent.availableToAddLeftChildren = true;
            parent.leftChild = null;
        }
        if (item.equals(parent.rightChild)) {
            parent.availableToAddRightChildren = true;
            parent.rightChild = null;
        }

        Queue<Entry> queue = new LinkedList<>();
        queue.add(item);
        while (!queue.isEmpty()) {
            if (item.leftChild!=null) queue.add(item.leftChild);
            if (item.rightChild!=null) queue.add(item.rightChild);
            queue.remove();
            size--;
            item = queue.peek();
        }
        return true;


//        return super.remove(o);
    }

    private int size = 0;
    private  List<Entry> list = new ArrayList<>();

    @Override
    public boolean add(String s) {
        if (root == null) { // если вставляется корневой элемент
            Entry<String> entry = new Entry<>(s);
            root = entry;
            entry.availableToAddLeftChildren = true;
            entry.availableToAddRightChildren = true;
            entry.parent = entry;
            list.add(entry);

        } else {                        // если вставляется НЕкорневой элемент

//            Entry<String> entry = new Entry<>(s);
//            entry.elementName = s;
            Queue<Entry> queue = new LinkedList<>();

            queue.add(list.get(0));
            while (!queue.isEmpty()) {
                Entry current = queue.peek();
                if (!current.isAvailableToAddChildren()) { // если child уже заняты, добавляем в очередь проверки их
                    queue.add(current.leftChild);
                    queue.add(current.rightChild);
                    queue.remove();
                } else { // иначе добавляем новый элемент в child
                    Entry added = new Entry(s);
                    added.availableToAddLeftChildren = true;
                    added.availableToAddRightChildren = true;
                    added.parent = current;
                    if (current.availableToAddLeftChildren) { // добавляем либо левого child
                        current.leftChild = added;
                        current.availableToAddLeftChildren = false;
                    }
                    else {                                     // либо правого
                        current.rightChild = added;
                        current.availableToAddRightChildren = false;
                    }
                    list.add(added);
                    size++;
                    return true;
                }
            }

        }
        return true;
    }

    public CustomTree() {
        this.add("0");
        this.root = new Entry("0");
    }

//    public CustomTree(Entry root) {
//        this.root = root;
//    }

    @Override
    public int size() {
        if (root==null) return 0;
        else return size;
    }

    public String getParent(String s) {
        for (Entry entry : list) {
            if (entry.elementName.equals(s)) return entry.parent.elementName;
        }
        return null;
    }
//    public String getParent(String s) {
//        Entry entry = new Entry(s);
//        if (list.contains(entry)) return list.get(list.indexOf(entry)).parent.elementName;
//        else return null;
//    }
//    public String getParent(String s) {
//        Entry entry = new Entry(s);
//        return list.get(list.indexOf(entry)).parent.elementName;
//    }

    static class Entry<T> implements Serializable {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Entry<?> entry = (Entry<?>) o;

            return elementName.equals(entry.elementName);

        }

        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
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
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }


}

// удаление корневого