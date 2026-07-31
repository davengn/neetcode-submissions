class Solution {
    int[][] memo;
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        memo = new int[coins.length + 1][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(0, amount, coins);
    }
    private int dp(int i, int amount, int[] coins) {
        if (amount == 0)
            return 1;
        if (i >= coins.length) {
            return 0;
        }
        if (memo[i][amount] != -1) {
            return memo[i][amount];
        }
        int res = 0;
        if (amount >= coins[i]) {
            res = dp(i + 1, amount, coins);
            res += dp(i, amount - coins[i], coins);
        }
        memo[i][amount] = res;
        return memo[i][amount];
    }
}
