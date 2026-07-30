class Solution {
    Boolean[][] cache ;
    public boolean canPartition(int[] nums) {
        int size = nums.length;
        int total = 0;

        for (int n : nums) {
            total += n;
        }
        if (total % 2 != 0) {
            return false;
        }
        int target = total / 2;
        cache = new Boolean[size][target +1];
        return dp(0, target, nums);
    }
    private boolean dp(int i, int sum, int[] nums) {
        if (i >= nums.length) {
            return sum == 0;
        }
        if(sum < 0){
            return false;
        }
         if (cache[i][sum] != null) {
            return cache[i][sum];
        }
        cache[i][sum] =  dp(i +1, sum, nums) || dp(i +1, sum - nums[i],nums);
        return cache[i][sum] ;
    }
}
