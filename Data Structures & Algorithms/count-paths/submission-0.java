class Solution {
    int[][] visit;
    public int uniquePaths(int m, int n) {
        visit = new int[m][n];
        for (int[] it : visit) {
            Arrays.fill(it, -1);
        }
        return dfs(0, 0, m, n);
    }
    private int dfs(int r, int c, int m, int n) {
        if(r >=m || c >=n){
            return 0;
        }
        if (r == m - 1 & c == n - 1) {
            return 1;
        }
        
        if (visit[r][c] != -1) {
            return visit[r][c];
        }
        visit[r][c] = dfs(r + 1, c, m, n) + dfs(r, c + 1, m, n);
        return visit[r][c];
    }
}
