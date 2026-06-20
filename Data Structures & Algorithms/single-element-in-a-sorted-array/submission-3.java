class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n =nums.length;
        for(int i = 0; i< n;i++){
            if(i ==0 || nums[i] == nums[i-1] || (i < n-1 && nums[i] == nums[i+1])){
                continue;
            }
            return nums[i];
        }
        return nums[0];
    }
}