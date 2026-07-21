class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> subset = new ArrayList<>();
        dfs(0, nums, target, subset);
        return res;
    }
    private void dfs(int i, int[] nums, int target, List<Integer> subset) {
        if (target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }
         if (target < 0 || i >= nums.length) {
            return;
        }
        subset.add(nums[i]);
        dfs(i, nums, target - nums[i], subset);
        subset.remove(subset.size() -1);
        dfs(i + 1, nums, target, subset);
    }
}
