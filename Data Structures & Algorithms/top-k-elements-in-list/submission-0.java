class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            cache.put(nums[i], cache.getOrDefault(nums[i], 0) + 1);
        }
        return cache.entrySet().stream()
            .sorted(Map.Entry.<Integer, Integer>comparingByValue()
                .thenComparing(Map.Entry.comparingByKey())
                .reversed())
                .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();
    }
}
