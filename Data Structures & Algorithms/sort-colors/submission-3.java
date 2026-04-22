class Solution {
    public void sortColors(int[] nums) {
        Map<Integer,Integer> buckets = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            buckets.put(nums[i],buckets.getOrDefault(nums[i],0) +1);
        }
        int i = 0;
        int k = 0;
        while(i<3){
            int count = buckets.getOrDefault(i,0);
            while(k < nums.length && count > 0){
                nums[k] = i;
                k++;
                count--;
            }
            i++;
        }
    }
}