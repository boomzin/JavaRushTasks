package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private OriginalRetriever originalRetriever;
    private LRUCache<Long, Object> lruCache = new LRUCache<>(10);

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        if (lruCache.find(id) == null) {
            lruCache.set(id, originalRetriever.retrieve(id));
        } else {
            System.out.println("Getting a value for id #" + id + " from RemoteStorage...");
        }
        return lruCache.find(id);

    }
}
