class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int rows, cols;
    int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == INF) {
                    grid[r][c] = bfs(grid, r, c);
                }
            }
        }
    }
    private int bfs(int[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        boolean[][] visit = new boolean[rows][cols];
        visit[r][c] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i <size ; i++) {
                int[] node = queue.poll();
                int row = node[0];
                int col = node[1];
                if (grid[row][col] == 0)
                    return level;
                for (int[] dir : directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] == -1
                        || visit[nr][nc]) {
                        continue;
                    }

                    queue.add(new int[] {nr, nc});
                    visit[nr][nc] = true;
                }
            }

            level++;
        }
        return INF;
    }
}
