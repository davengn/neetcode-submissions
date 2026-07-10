class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = low + k -1;
        int res = Integer.MAX_VALUE;
        while(high < nums.length){
            int diff = nums[high] - nums[low];
            res = Math.min(res,diff);
            low++;
            high++;
            
        }
        return res;
    }
}