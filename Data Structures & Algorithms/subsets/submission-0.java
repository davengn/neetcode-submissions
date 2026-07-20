class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        backtrack(0, nums,subset);
        return res;
    }
    private void backtrack(int index, int[] nums, List<Integer> subset) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        backtrack(index + 1, nums, subset);
        subset.remove(subset.size() - 1);
        backtrack(index + 1, nums, subset);
    }
}
