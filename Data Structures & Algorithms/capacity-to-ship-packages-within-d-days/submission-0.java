class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int min = 0;
        int left = 0;
        int right = weights.length - 1;
        while (left <= right) {
            min = Math.max(min, Math.max(weights[left], weights[right]));
            if (left == right) {
                max += weights[left];
                break;
            }
            int sum = weights[left] + weights[right];
            max += sum;
            left++;
            right--;
        }
        int low = min;
        int high = max;
        int res = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canShip(weights, days, mid)) {
                res= mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
    private boolean canShip(int[] w, int days, int cap) {
        int ship = 1;
        int curCap = cap;
        for(int i = 0; i < w.length; i++ ){
            if(curCap - w[i] < 0){
                ship++;
                if(ship > days){
                    return false;
                }
                 curCap = cap;
            }
            curCap -=w[i];
        }
        return true;
    }
}