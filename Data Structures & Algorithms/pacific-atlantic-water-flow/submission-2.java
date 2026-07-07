class Solution {
    int rows, cols;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] alt = new boolean[rows][cols];
        Queue<int[]> qPac = new LinkedList<>();
        Queue<int[]> qAlt = new LinkedList<>();
        for (int c = 0; c < cols; c++) {
            qPac.add(new int[] {0, c});
            qAlt.add(new int[] {rows - 1, c});
        }
        for (int r = 0; r < rows; r++) {
            qPac.add(new int[] {r, 0});
            qAlt.add(new int[] {r, cols - 1});
        }
        bfs(qPac, pac, heights);
        bfs(qAlt, alt, heights);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pac[r][c] && alt[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }
    private void bfs(Queue<int[]> queue, boolean[][] visit, int[][] grid) {
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
        
            visit[row][col] = true;

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr < 0 || nr >= rows || nc < 0 || nc >=cols){
                    continue;
                }
                if (grid[nr][nc] >= grid[row][col] && !visit[nr][nc]) {
                    queue.add(new int[] {nr, nc});
                }
            }
        }
    }
}
