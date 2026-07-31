class Solution {
    private Map<String, Integer> memo = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dp(0, true, prices);
    }
    private int dp(int i, boolean canBuy, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }
        String key = i + "-" + canBuy;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int cooldown = dp(i + 1, canBuy, prices);
        if (canBuy) {
            int buying = dp(i + 1, false, prices) - prices[i];
            memo.put(key, Math.max(cooldown, buying));

        } else {
            int selling = dp(i + 2, true, prices) + prices[i];
            memo.put(key, Math.max(cooldown, selling));
        }
        return memo.get(key);
    }
}
