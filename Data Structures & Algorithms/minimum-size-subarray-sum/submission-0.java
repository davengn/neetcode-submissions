class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int r = 0;
        int l = 0;

        int prefixSum = 0;

        while (r < nums.length) {
            prefixSum += nums[r];
            while (prefixSum >= target) {
                min = Math.min(min, r - l + 1);
                prefixSum -= nums[l];
                l++;
            }
            r++;
            
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}