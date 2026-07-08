class Solution {
    List <List<Integer>> graph = new ArrayList<>();
    public int[] findRedundantConnection(int[][] edges) {
        for(int i = 0 ; i <= edges.length ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            boolean[] visit = new boolean[edges.length +1];
            if(dfs(edge[0],-1,visit)){
                return edge;
            }
        }
       return new int[0];
    }
    private boolean dfs(int node,int parent,boolean[] visit){
        if(visit[node]){
            return true;
        }
        visit[node] = true;
        List<Integer> neighbors = graph.get(node);
        for(Integer nei : neighbors){
            if(nei == parent) continue;
            if(dfs(nei,node,visit)) return true;
        }
        return false;
    }
}
