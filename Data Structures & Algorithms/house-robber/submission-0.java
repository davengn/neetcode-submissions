class Solution {
    int[] cache;
    public int rob(int[] nums) {
        cache = new int[nums.length];
        return dp(0,nums,cache);
    }
    private int dp(int i , int[] nums,int[] cache){
        if(i >= nums.length){
            return 0;
        }
        if(cache[i] !=0) return cache[i];
        cache[i] = Math.max(nums[i] + dp(i + 2,nums,cache), dp(i + 1,nums,cache) );
        return cache[i];
    }
}
