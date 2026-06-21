class Solution {
    public int findPeakElement(int[] nums) {
        int peak = 0;
        int n = nums.length;
        for(int i = 1; i < n; i++){
            if(nums[peak] < nums[i]){
                peak = i;
            }
        }
        return peak;
      
    }
}