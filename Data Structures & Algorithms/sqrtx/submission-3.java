class Solution {
    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        int res = 0;
        while(low <= high){
            int mid = low + (high - low) /2;
            long sqrt = (long) mid * mid;
            if( sqrt== x){
                return mid;
            }else if(sqrt > x){
                high = mid -1;
            }else{
                low = mid +1;
                res= mid;
            }
        }

        return res;
    }
}