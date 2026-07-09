class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[] {time[1], time[2]});
        }
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // [node, time]
        pq.add(new int[] {k, 0});
        boolean[] visited = new boolean[n + 1];
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];
            if (visited[node])
                continue;
            visited[node] = true;
            List<int[]> edges = adj.getOrDefault(node,new ArrayList<>());
            for (int[] edge : edges) {
                int next = edge[0];
                int weight = edge[1];
                if (!visited[next] && time + weight < dist[next]) {
                    dist[next] = time + weight;
                    pq.add(new int[] {next, dist[next]});
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}
