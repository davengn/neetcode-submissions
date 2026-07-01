class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] hasAppleList;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        hasAppleList = new boolean[n];
        for (int i = 0; i < n; i++) {
            hasAppleList[i] = hasApple.get(i);
        }
        return dfs(0, -1);
    }
    private int dfs(int node, int parent) {
        int totalTime = 0;
        for (int child : graph.get(node)) {
            if (child == parent)
                continue;
            int childTime = dfs(child, node);
            if (childTime > 0 || hasAppleList[child]) {
                totalTime += childTime + 2; // 2 = go there and come back
            }
        }
        return totalTime;
    }
}