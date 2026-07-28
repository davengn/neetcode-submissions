class Solution {
    int res = 0;
    int[] cache;
    public int numDecodings(String s) {
        cache = new int[s.length()];
        return dfs(0, s);
    }
    private int dfs(int i, String s) {
        if(i >= s.length()) return 1;
        if (cache[i] > 0)
            return cache[i];

        if (s.charAt(i) == '0')
            return 0;
        res = dfs(i + 1, s);

        if (i + 1 < s.length()
            && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
            res += dfs(i + 2, s);
        }
        cache[i] = res;
        return cache[i];
    }
}
