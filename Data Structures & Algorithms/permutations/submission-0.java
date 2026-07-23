class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        backtrack(nums, subset, visit);
        return res;
    }
    private void backtrack(int[] nums, List<Integer> subset, boolean[] visit) {
        if (subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!visit[j]) {
                subset.add(nums[j]);
                visit[j] = true;
                backtrack(nums, subset, visit);
                subset.remove(subset.size() - 1);
                visit[j] = false;
            }
        }
    }
}
