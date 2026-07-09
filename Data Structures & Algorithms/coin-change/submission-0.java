class Solution {
    Map<Integer, Integer> cache = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int min = dfs(coins, amount);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public int dfs(int[] coins, int current) {
        if (current == 0)
            return 0;
        if (cache.containsKey(current))
            return cache.get(current);
        int res = Integer.MAX_VALUE;
        for (int c : coins) {
            if (current - c >= 0) {
                int result = dfs(coins, current - c);
                if (result != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + result);
                }
            }
        }
        cache.put(current, res);
        return res;
    }
}
