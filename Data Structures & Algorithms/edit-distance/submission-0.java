class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0, word1, word2);
    }
    private int dfs(int i, int j, String w1, String w2) {
        if (i >= w1.length()) {
            return w2.length() - j;
        }
        if (j >= w2.length()) {
            return w1.length() - i;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (w1.charAt(i) == w2.charAt(j)) {
            memo[i][j] = dfs(i + 1, j + 1, w1, w2);
            return memo[i][j];
        }
        memo[i][j] = Math.min(dfs(i, j + 1, w1, w2), dfs(i + 1, j, w1, w2));
        memo[i][j] = Math.min(memo[i][j], dfs(i + 1, j + 1, w1, w2));
        memo[i][j] +=1;
        return memo[i][j];
    }
}
