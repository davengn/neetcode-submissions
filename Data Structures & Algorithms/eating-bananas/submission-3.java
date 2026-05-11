class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxK = 0;
        for (Integer p : piles) {
            if (p > maxK) {
                maxK = p;
            }
        }
        int k = maxK;
        int start = 0;
        int end = k;
        while (start <= end) {
            int tmpTime = 0;
            int mid = (start + end) / 2;
            for (Integer p : piles) {
                tmpTime += Math.ceil((double) p / mid);
            }
            if (tmpTime == h) {
            }
            if (tmpTime > h) {
                start = mid + 1;
            } else if (tmpTime <= h) {
                k = Math.min(k, mid);
                end = mid - 1;
            }
        }

        return k;
    }
}
