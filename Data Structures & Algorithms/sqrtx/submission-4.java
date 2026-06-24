class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int res = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            long sqrt = (long) m * m;
            if (sqrt == x) {
                return m;
            } else if (sqrt > x) {
                r = m - 1;
            } else {
                res = m;
                l = m + 1;
            }
        }
        return res;
    }
}