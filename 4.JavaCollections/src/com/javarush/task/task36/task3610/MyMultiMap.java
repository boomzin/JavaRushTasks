package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        Integer count = 0;
        for (HashMap.Entry<K, List<V>> entry : map.entrySet()) {
            count += entry.getValue().size();
        }
        return count;
    }

    @Override
    public V put(K key, V value) {
        if (!map.containsKey(key)) {
            List<V> newMapValue = new LinkedList<>();
            if (repeatCount > 0) {
                newMapValue.add(value);
            }
            map.put(key, newMapValue);
            return null;
        }
        List<V> mapValue = map.get(key);
        int mapValueCapacity = mapValue.size();
        V lastAddedValue = mapValue.get(mapValue.size() - 1);
        if (mapValueCapacity == repeatCount) {
            mapValue.remove(0);
        }
        mapValue.add(value);
        map.put(key, mapValue);
        return lastAddedValue;
        //напишите тут ваш код
    }

    @Override
    public V remove(Object key) {
        if (!map.containsKey(key)) {
            return null;
        }
        List<V> foundedMapValue = map.get(key);
        if (foundedMapValue.size() == 0) {
            map.remove(key, foundedMapValue);
            return null;
        }
        V removedValue = foundedMapValue.get(0);
        if (foundedMapValue.size() == 1) {
            map.remove(key, foundedMapValue);
            return removedValue;
        }
        foundedMapValue.remove(0);
        return removedValue;

        //напишите тут ваш код
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
        //напишите тут ваш код
    }

    @Override
    public Collection<V> values() {
        List<V> allValues = new ArrayList<>();
        for (HashMap.Entry<K, List<V>> entry : map.entrySet()) {
            allValues.addAll(entry.getValue());
        }
        return allValues;
        //напишите тут ваш код
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
        //напишите тут ваш код
    }

    @Override
    public boolean containsValue(Object value) {
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            if (entry.getValue().contains(value)) {
                return true;
            }
        }
        return false;
        //напишите тут ваш код
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}