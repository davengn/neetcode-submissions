class Solution {
    public int arrangeCoins(int n) {
        int curCap = n;
        int row = 0;
        while (curCap > row) {
            row++;

            curCap -= row;
        }
        return row;
    }
}