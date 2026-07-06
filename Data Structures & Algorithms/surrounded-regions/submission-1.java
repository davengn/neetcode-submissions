class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int rows, cols;
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;
        bfs(board);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board) {
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 || r == rows - 1 || c == 0 || c == cols - 1 && board[r][c] == 'O') {
                    queue.add(new int[] {r, c});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            if (board[row][col] == 'O') {
                board[row][col] = 'T';
                for (int dir[] : directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                        continue;
                    }

                    queue.add(new int[] {nr, nc});
                }
            }
        }
    }
}
