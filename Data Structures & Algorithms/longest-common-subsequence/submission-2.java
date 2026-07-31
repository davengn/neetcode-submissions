class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, 0, text1, text2);
    }
    private int dp(int i, int j, String t1, String t2) {
        if (i >= t1.length() || j >= t2.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        memo[i][j] = 0;
        if (t1.charAt(i) == t2.charAt(j)) {
            memo[i][j] = 1 + dp(i + 1, j + 1, t1, t2);
        } else {
            memo[i][j] = Math.max(dp(i + 1, j, t1, t2), dp(i, j + 1, t1, t2));
        }
        return memo[i][j];
    }
}
