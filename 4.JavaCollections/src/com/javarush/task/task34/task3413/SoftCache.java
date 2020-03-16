package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);
        if (cacheMap.containsKey(key)) {
            return softReference.get();
        }
        else return null;

        //напишите тут ваш код
    }

    public AnyObject put(Long key, AnyObject value) {
        if (!cacheMap.containsKey(key)) {
            return null;
        } else {
            SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
            AnyObject result = softReference.get();
            softReference.clear();
            return result;
        }

        //напишите тут ваш код
    }

    public AnyObject remove(Long key) {
        if (!cacheMap.containsKey(key)) {
            return null;
        } else {
            SoftReference<AnyObject> softReference = cacheMap.get(key);
            AnyObject result = softReference.get();
            softReference.clear();
            return result;
        }

        //напишите тут ваш код
    }
}