class Solution {
    public int arrangeCoins(int n) {
          if (n <= 3) {
            return n == 1 ? 1 : n - 1;
        }
        int left = 1;
        int right = (n / 2) + 1;
        int row = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long cost = (long) mid * (mid + 1) / 2;
            System.out.println(mid);
            if (cost <= n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }
}