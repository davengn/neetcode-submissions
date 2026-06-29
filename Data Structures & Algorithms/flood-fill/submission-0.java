class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[] {sr, sc});
        int org = image[sr][sc];
        Set<String> visited = new HashSet<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!stack.isEmpty()) {
            Integer[] node = stack.pop();
            int r = node[0];
            int c = node[1];
            String key = r + "," + c;
            if (visited.contains(key)) {
                continue;
            }
            if (r < 0 || r >= rows || c < 0 || c >= cols) {
                continue;
            }
            if (image[r][c] != org) {
                continue;
            }
            image[r][c] = color;
            visited.add(key);
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                stack.push(new Integer[] {newRow, newCol});
            }
        }
        return image;
    }
}