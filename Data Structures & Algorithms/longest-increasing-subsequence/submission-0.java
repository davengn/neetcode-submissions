class Solution {
    int[] memo;
    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp(i, nums));
        }
        return max;
    }
    private int dp(int i, int[] nums) {
        if (memo[i] != -1) {
            return memo[i];
        }
        int res = 1;
        for(int j = i ; j < nums.length; j++){
            if(nums[j] > nums[i]){
                 res = Math.max(res, 1+ dp(j,nums));
            }
        }
        memo[i] = res;
        return res;
    }
}
