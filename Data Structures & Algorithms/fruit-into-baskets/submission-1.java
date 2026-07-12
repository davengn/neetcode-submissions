class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = left ;
        Map<Integer, Integer> cache = new HashMap<>();
        int max = 0;
        int total = 0;
        while (right < fruits.length) {
            cache.put(fruits[right], cache.getOrDefault(fruits[right], 0) + 1);
            total++;
            while (cache.size() > 2) {
                int f = fruits[left];
                cache.put(f, cache.get(f) - 1);
                total--;
                if(cache.get(f) == 0) {
                    cache.remove(f);
                }
                left++;
            }

            max = Math.max(max, total);
            right++;
        }
        return max;
    }
}