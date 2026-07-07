class Solution {
    int rows, cols;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (bfs(heights, r, c)) {
                    res.add(new ArrayList<>(List.of(r, c)));
                }
            }
        }
        return res;
    }
    private boolean bfs(int[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        boolean pacific = false;
        boolean atlantic = false;
        boolean[][] visited = new boolean[rows][cols];
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            if (visited[row][col])
                continue;
            visited[row][col] = true;
            if (pacific && atlantic) {
                break;
            }
            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr < 0 || nc < 0) {
                    pacific = true;
                } else if (nr >= rows || nc >= cols) {
                    atlantic = true;
                } else if (grid[nr][nc] <= grid[row][col]) {
                    queue.add(new int[] {nr, nc});
                }
            }
        }
        return pacific && atlantic;
    }
}
