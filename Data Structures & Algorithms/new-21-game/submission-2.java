class Solution {
    Map<Integer, Double> cache = new HashMap<>();
    public double new21Game(int n, int k, int maxPts) {
        double windowSum = 0;
        if(k ==0) return 1.0;
        for (int i = k; i < k + maxPts; i++) {
            windowSum += i <= n ? 1.0 : 0.0;
        }
        for (int i = k - 1; i >= 0; i--) {
            cache.put(i, windowSum / maxPts);
            double remove = 0.0;
            if (i + maxPts <= n) {
                remove = cache.getOrDefault(i + maxPts, 1.0);
            }
            windowSum += cache.get(i) - remove;
        }
        return cache.get(0);
    }
}