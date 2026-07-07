class Solution {
    int rows, cols;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[] {r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }
        int level = 0;
        while (fresh> 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int row = node[0];
                int col = node[1];
                for (int[] dir : directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                        continue;
                    }
                    if (grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.add(new int[] {nr, nc});
                    }
                }
            }
            level++;
        }
        return fresh > 0 ? -1 : level;
    }
}
