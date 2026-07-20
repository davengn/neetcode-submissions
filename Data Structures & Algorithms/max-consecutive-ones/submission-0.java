class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxSeen = 0;
        int max = 0;
        for(int i = 0; i< nums.length;i++){
            if(nums[i] == 0){
                max = Math.max(maxSeen,max);
                maxSeen = 0;
                continue;
            }
            maxSeen++;
        }
        return Math.max(max,maxSeen);
    }
}