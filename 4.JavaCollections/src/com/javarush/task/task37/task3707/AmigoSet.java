package com.javarush.task.task37.task3707;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int newCapacity = Math.max(16, (int)Math.ceil(collection.size()/.75f));
        map = new HashMap<>(newCapacity);
        collection.forEach(e -> map.put(e, PRESENT));
    }

    @Override
    public boolean add(Object e) {
        return map.put((E) e, PRESENT) == null;
    }

        private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        oos.writeInt(capacity);
        oos.writeFloat(loadFactor);
        oos.writeInt(map.size());
        map.forEach((k, v) -> {
            try {
                oos.writeObject(k);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
//        for(E e : map.keySet()) {
//            oos.writeObject(e);
//        }
    }
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        int capacity = ois.readInt();
        float loadFactor = ois.readFloat();
        int size = ois.readInt();
        map = new HashMap(capacity, loadFactor);
        for (int i = 0; i < size; i++) {
            map.put((E) ois.readObject(), PRESENT);
        }
    }



    @Override
    public Object clone() throws InternalError {
        try {
            AmigoSet<E> copy = (AmigoSet<E>)super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        } catch (Exception e) {
            throw new InternalError(e);
        }

    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Iterator iterator() {
        Iterator iterator = map.keySet().iterator();
        return iterator;
    }

    @Override
    public boolean equals(Object o) {
        if ((o == null)||!(o instanceof AmigoSet )) return false;

        if (this.hashCode()!= ((AmigoSet)o).hashCode()) return false;
        AmigoSet<E> compare = (AmigoSet)o;
        if (this.map.size()!= compare.map.size()) return false;
        for (E e: map.keySet()){
            if (!compare.contains(e)) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.map.hashCode() + PRESENT.hashCode();
    }

    @Override
    public int size() {
        return map.size();
    }
}
