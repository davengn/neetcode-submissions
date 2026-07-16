class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;
        int w = n - k;
        int windowSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += cardPoints[i];
            if (i < w) {
                windowSum += cardPoints[i];
            }
        }
        int res = windowSum;
        for (int r = w; r < n; r++) {
            windowSum = windowSum - cardPoints[r - w] + cardPoints[r];
            res = Math.min(windowSum, res);
        }
        return totalSum - res;
    }
}