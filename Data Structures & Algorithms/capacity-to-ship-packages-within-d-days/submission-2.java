class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxCap = 0;
        int minCap = 0;
        for(Integer w : weights){
            minCap = Math.max(minCap,w);
            maxCap+=w;
        }
        int low = minCap;
        int high = maxCap;
        int res = 0;
        while(low <=high){
            int mid = low + ( high - low) /2;
            if(canShip(weights,mid,days)){
                res = mid;
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return res;
    }
    private boolean canShip(int[] nums, int cap, int days ){
        int ship = 1;
        int resetCap = cap;
        for(Integer n : nums){
            if(resetCap - n < 0){
                ship++;
                if (ship > days) {
                    return false;
                }
                resetCap = cap;
            }
            resetCap -= n;
        }
        return true;
    }
}