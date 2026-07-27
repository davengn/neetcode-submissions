class Solution {
    int[] cache;
    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length];
        return Math.min(dfs(0,cache,cost), dfs(1, cache,cost));
    }
    private int dfs(int i , int[] cache,int[] cost){
        if(i >= cost.length){
            return 0;
        }
        if(cache[i] > 0) return cache[i];
        cache[i] = cost[i] + Math.min(dfs(i +1,cache,cost), dfs(i+2,cache,cost));
        return cache[i];
    }
}
