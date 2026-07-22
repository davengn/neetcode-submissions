class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, 0, target, subset);
        return res;
    }
    private void backtrack(int i, int[] nums, int total, int target, List<Integer> subset) {
        if (total == target) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            if (total + nums[j] > target) {
                break;
            }
            subset.add(nums[j]);
            backtrack(j + 1, nums, total + nums[j], target, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
