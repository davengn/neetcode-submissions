class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxK = 0;
        for(Integer p : piles){
            maxK = Math.max(maxK,p);
        }
        int l = 1;
        int r = maxK;
        int res = Integer.MAX_VALUE;
        while(l <= r){
            int m = l + (r -l) /2;
            int totalH = 0;
            for(Integer p : piles){
                int hours = p/m;
                if(p % m > 0){
                    hours +=1;
                }
                totalH+=hours;
            }
            System.out.println(totalH+ "-" +m);
            if(totalH <= h){
                res = Math.min(res,m);
                r = m-1;

            }else{
                l = m +1;

            }
        }
        return res;
    }
}
