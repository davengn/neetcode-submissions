class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sub = new StringBuilder();
        backtrack(0, 0, n, sub);
        return res;
    }
    private void backtrack(int close, int open, int n, StringBuilder sub) {
        if (open == close && open == n) {
            res.add(sub.toString());
            return;
        }

        if (open < n) {
            sub.append('(');
            backtrack(close, open +1, n, sub);
            sub.deleteCharAt(sub.length() - 1);
        }
        if (close < open) {
            sub.append(')');
            backtrack(close +1, open, n, sub);
            sub.deleteCharAt(sub.length() - 1);
        }
    }
}
