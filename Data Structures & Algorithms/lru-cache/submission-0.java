class LRUCache {
    Map<Integer, Integer> cache;
    int maxCapacity; // 1. Save the capacity here
    public LRUCache(int capacity) {
        maxCapacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.maxCapacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
 
        cache.put(key, value);
    }
}
