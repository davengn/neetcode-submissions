class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> cache = new HashMap<>();
        for(int i = 0 ; i< n; i++){
            int tmp = cache.getOrDefault(nums[i],0)+1;
            cache.put(nums[i],tmp);
            if(tmp > n/3 &&tmp < n/3 +2){
                result.add(nums[i]);
            }
            
        }
        
        return result;
    }
}