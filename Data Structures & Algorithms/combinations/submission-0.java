class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> subset = new ArrayList<>();
        backtrack(1,n,k,subset);
        return res;
    }
    private void backtrack(int i, int n, int k, List<Integer> subset) {
        if (i > n) {
            if (subset.size() == k) {
                res.add(new ArrayList<>(subset));
            }
            return;
        }
            subset.add(i);
            backtrack(i+1,n,k,subset);
            subset.remove(subset.size() -1);
            backtrack(i+1,n,k,subset);

    }
}