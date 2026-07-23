class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,nums,subset);
        return res;
    }
    private void backtrack(int i, int[] nums, List<Integer> subset){
            res.add(new ArrayList<>(subset));
     
        for(int j = i; j < nums.length;j++){
            if(j > i && nums[j] == nums[j-1]){
                continue;
            }
            subset.add(nums[j]);
            backtrack(j +1, nums,subset);
            subset.remove(subset.size() -1);
        }
    }
}
