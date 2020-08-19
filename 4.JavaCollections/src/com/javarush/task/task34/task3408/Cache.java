package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            Class[] params = {key.getClass()};
            V newValue = (V) clazz.getConstructor(params).newInstance(key);
            cache.put(key, newValue);
            return newValue;
        }
        //TODO add your code here
    }

    public boolean put(V obj) {
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            K key = (K) method.invoke(obj);
            cache.put(key, obj);
            return true;
            //TODO add your code here
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return false;
    }

    public int size() {
        return cache.size();
    }
}
