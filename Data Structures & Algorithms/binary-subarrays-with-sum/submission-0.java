class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> cache =new HashMap<>();
        cache.put(0,1);
        int prefix = 0;
        int res = 0;
        for(int num : nums){
            prefix += num;
            res+= cache.getOrDefault(prefix - goal,0);
            cache.put(prefix, cache.getOrDefault(prefix ,0) +1);
        }
        return res;
    }
}