class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n +1];
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[] {time[1], time[2]});
        }
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dfs(k, 0, adj, dist);
        Arrays.sort(dist); 
        
        // Get the last element
        int max = dist[dist.length - 1];
        return max == Integer.MAX_VALUE ? -1 : max;
    }
    private void dfs(int node, int time, Map<Integer, List<int[]>> adj, int[] dist) {
        if(time >= dist[node]) return;
        dist[node] = time;
        if(!adj.containsKey(node)) return;
        List<int[]> edges = adj.get(node);
        for(int[] edge : edges){
            dfs(edge[0],time + edge[1],adj,dist);
        }
    }
}
