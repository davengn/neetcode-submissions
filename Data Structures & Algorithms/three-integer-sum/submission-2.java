class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n-1; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int k = n - 1;
            int j = i + 1;
            while (k > j) {
                int threeSum =  nums[i] +  nums[j] + nums[k];
                if (threeSum > 0) {
                    k--;
                }else if(threeSum < 0){
                    j++;
                }else{
                    res.add(new ArrayList<>(List.of(nums[i],nums[j],nums[k])));
                    k--;
                    j++;
                    while(j< k && nums[j] == nums[j-1]  ){
                        j++;
                    }
                }
                
            }
        }
        return new ArrayList<>(res);
    }
}
