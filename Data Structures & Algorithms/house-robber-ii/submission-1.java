class Solution {
    int[][] cache;
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        cache = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            cache[i][0] = -1;
            cache[i][1] = -1;
        }
        return Math.max(dp(0, nums, cache, 1), dp(1, nums, cache, 0));
    }
    private int dp(int i, int[] nums, int[][] cache, int flag) {
        if (i >= nums.length || (flag == 1 && i == nums.length - 1)) {
            return 0;
        }
        if (cache[i][flag] != -1)
            return cache[i][flag];
        cache[i][flag] = Math.max(nums[i] + dp(i + 2, nums, cache, flag | (i == 0 ? 1 : 0)),
            dp(i + 1, nums, cache, flag));
        return cache[i][flag];
    }
}
