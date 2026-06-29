class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int startR = -1, startC = -1;
        for (int r = 0; r < rows && startR == -1; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    startR = r;
                    startC = c;
                    break;
                }
            }
        }
        return dfs(grid, startR, startC);
    }
    private int dfs(int[][] grid, int startR, int startC) {
        int rows = grid.length;
        int cols = grid[0].length;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        stack.push(new Pair<>(startR, startC));
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int perimeter = 0;
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> node = stack.pop();
            int r = node.getKey();
            int c = node.getValue();
            if (visited.contains(node))
                continue;
            if (r < 0 || r >= rows || c < 0 || c >= cols) {
                perimeter++;
                continue;
            }
            if (grid[r][c] == 0) {
                perimeter++;
                continue;
            }
            visited.add(node);
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                stack.push(new Pair<Integer, Integer>(newRow, newCol));
            }
        }
        return perimeter;
    }
}