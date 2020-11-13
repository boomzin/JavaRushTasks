package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;
    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    int size;

    public void setMaxBucketSize(long maxBucketSize) {
        this.maxBucketSize = maxBucketSize;
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    int hash(Long k) {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    int indexFor(int hash, int length) {
        return hash & (length-1);
    }

    Entry getEntry(Long key) {
        int hash = (key == null) ? 0 : hash(key);
        for (Entry e = table[indexFor(hash, table.length)].getEntry(); e != null; e = e.next) {
            Long k;
            if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                return e;
            }
        }
        return null;
    }

    void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    void transfer(FileBucket[] newTable) {
        for (FileBucket fileBucket : table) {
            if (fileBucket.getFileSize() > 0) {
                Entry entry = fileBucket.getEntry();
                fileBucket.remove();
                while (entry != null) {
                    Entry next = entry.next;
                    int newIndex = indexFor(entry.hash, newTable.length);
                    entry.next = newTable[newIndex].getEntry();
                    newTable[newIndex].putEntry(entry);
                    entry = next;
                }
            }
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry entry = null;
        if (table[bucketIndex] != null) {
            entry = table[bucketIndex].getEntry();
        } else {
            table[bucketIndex] = new FileBucket();
        }
        table[bucketIndex].putEntry(new Entry(hash, key, value, entry));
        if (table[bucketIndex].getFileSize() >= bucketSizeLimit) {
            resize(2 * table.length);
        }
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        FileBucket[] tab = table;
        for (int i = 0; i < tab.length ; i++) {
            if (tab[i] != null) {
                for (Entry e = tab[i].getEntry(); e != null; e = e.next) {
                    if (value.equals(e.value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        if (table[i] != null) {
            for (Entry e = table[i].getEntry(); e != null; e = e.next) {
                Long k;
                if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                    e.value = value;
                    return;
                }
            }
        }
        addEntry(hash, key, value, i);
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (Entry e = table[i].getEntry(); e != null; e = e.next) {
                    if (value.equals(e.value)) {
                        return e.key;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        int hash = (key == null) ? 0 : hash(key);
        for (Entry e = table[indexFor(hash, table.length)].getEntry(); e != null; e = e.next) {
            Long k;
            if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                return e.value;
            }
        }
        return null;

    }
}
