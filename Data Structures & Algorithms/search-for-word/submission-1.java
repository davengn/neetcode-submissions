class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    boolean[][] visit;
    int rows = 0;
    int cols = 0;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        visit = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(0, r, c, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int i, int r, int c, char[][] board, String word) {
        if (i == word.length()) {
            return true;
        }
        if (r >= rows || r < 0 || c >= cols || c < 0 || board[r][c] != word.charAt(i)
            || visit[r][c]) {
            return false;
        }
        visit[r][c] = true;
        boolean res = false;

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (dfs(i + 1, nr, nc, board, word)) {
                res = true;
            }
        }
        visit[r][c] = false;
        return res;
    }
}
