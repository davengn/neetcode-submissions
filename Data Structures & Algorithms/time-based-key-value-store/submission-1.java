class TimeMap {
    Map<String, List<Pair<Integer, String>>> store;
    public TimeMap() {
        this.store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> result = store.getOrDefault(key, new ArrayList<>());
        int left = 0;
        int right = result.size() - 1;
        String res = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int curTime = result.get(mid).getKey();
            String value = result.get(mid).getValue();
            if (curTime <= timestamp) {
                res = value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
