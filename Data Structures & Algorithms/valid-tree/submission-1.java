class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        queue.add(new int[] {0, -1});
        visit.add(0);
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];
            for (int nei : adj.get(node)) {
                if (nei == parent) {
                    continue;
                }
                if (visit.contains(nei))
                    return false;
                visit.add(nei);
                queue.add(new int[]{nei,node});
            }
        }
        return visit.size() ==n;
    }
}
