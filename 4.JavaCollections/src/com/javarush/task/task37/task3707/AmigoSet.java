package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    @Override
    public Object clone() throws InternalError {
        AmigoSet clone;
        try {
           clone =  (AmigoSet) super.clone();
            clone.map = (HashMap) this.map.clone();
        } catch (Exception e) {
            throw new InternalError();
        }


        return clone;
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16, (int)Math.ceil(collection.size()/.75f));
        map = new HashMap<>(capacity);
        this.addAll(collection);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }

    @Override
    public int size() {
        return map.size();
    }

    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        out.writeInt(capacity);
        out.writeInt(map.size());
        out.writeFloat(loadFactor);
        for (E e : map.keySet()) {
            out.writeObject(e);
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int capacity = in.readInt();
        int size = in.readInt();
        float loadFactor = in.readFloat();
        this.map = new HashMap<>(capacity, loadFactor);
        for (int i = 0; i < size; i++) {
            E e = (E) in.readObject();
            map.put(e, PRESENT);
        }

    }

    public static void main(String[] args) throws Exception {
        AmigoSet initialAmigoSet = new AmigoSet<>();

        for (int i = 0; i < 10; i++) {
            initialAmigoSet.add(i);
        }


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(initialAmigoSet);

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        AmigoSet loadedAmigoSet = (AmigoSet) objectInputStream.readObject();

        System.out.println(initialAmigoSet.size() + " " + loadedAmigoSet.size());
    }


}
