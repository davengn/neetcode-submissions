class Solution {
    List <List<Integer>> graph = new ArrayList<>();
    boolean[] visit;
    public int countComponents(int n, int[][] edges) {
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        for (int node = 0; node < n; node++) {
            if(!visit[node]){
                bfs(node);
                res++;
            }
        }
        return res;
    }
    private void bfs(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visit[node] = true;
        while(!queue.isEmpty()){
            int nd = queue.poll();
            List<Integer> neighbors = graph.get(nd);
            for(Integer nei : neighbors){
                if(!visit[nei]){
                    queue.add(nei);
                    visit[nei] = true;
                }
            }
        }
    }
}
