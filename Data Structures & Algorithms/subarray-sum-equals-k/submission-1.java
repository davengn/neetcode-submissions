class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int curSum = 0;
        Map<Integer,Integer> cache = new HashMap<>();
        cache.put(0,1);
        for(int i = 0 ;i < nums.length; i++){
            curSum += nums[i];
            int diff = curSum - k;
            count+= cache.getOrDefault(diff,0);
            cache.put(curSum, cache.getOrDefault(curSum,0) +1);
        }
        return count;
    }
}