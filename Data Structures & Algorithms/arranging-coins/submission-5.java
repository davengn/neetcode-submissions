class Solution {
    public int arrangeCoins(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int m = l + (r - l) / 2;
            long cost = (long) m * (m + 1) / 2;
            if (cost <= n) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l - 1;
    }
}