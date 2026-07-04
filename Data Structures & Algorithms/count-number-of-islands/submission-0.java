class Solution {
    int rows, cols;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int res = 0;
        rows = grid.length;
        cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    res++;
                }
            }
        }
        return res;
    }
    private void bfs(char[][] grid, int r, int c) {
        if (grid[r][c] == '0')
            return;
        grid[r][c] = '0';

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
            if(grid[nr][nc] == '1'){
                bfs(grid,nr,nc);
            }
        }
    }
}
