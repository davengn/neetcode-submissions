class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, subset, visit);
        return res;
    }
    private void backtrack(int[] nums, List<Integer> subset, boolean[] visit) {
        if (subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (visit[j] || j > 0 && nums[j] == nums[j - 1] && !visit[j - 1]) {
                continue;
            }
            subset.add(nums[j]);
            visit[j] = true;
            backtrack(nums, subset, visit);
            subset.remove(subset.size() - 1);
            visit[j] = false;
        }
    }
}