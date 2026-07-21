class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> subset = new ArrayList<>();
        dfs(0, nums, target, subset, 0);
        return res;
    }
    private void dfs(int index, int[] nums, int target, List<Integer> subset, int total) {
        if (total == target) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (total + nums[i] > target) {
                continue;
            }
            subset.add(nums[i]);
            dfs(i, nums, target, subset, total + nums[i]);
            subset.remove(subset.size() - 1);
        }
    }
}
