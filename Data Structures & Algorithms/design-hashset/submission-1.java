class MyHashSet {
    List<LinkedList<Integer>> buckets;

    public MyHashSet() {
        this.buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new LinkedList<Integer>());
        }
    }

    public void add(int key) {
        int index = this.hashCode(key);
        Iterator<Integer> iterator = buckets.get(index).iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) {
                return;
            }
        }
        buckets.get(index).add(key);
    }

    public void remove(int key) {
        int index = this.hashCode(key);
        ListIterator<Integer> iterator = buckets.get(index).listIterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) {
                iterator.remove();
            }
        }
    }

    public boolean contains(int key) {
        int index = this.hashCode(key);
        Iterator<Integer> iterator = buckets.get(index).iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) {
                return true;
            }
        }

        return false;
    }

    private int hashCode(int key) {
        return key % buckets.size();
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */