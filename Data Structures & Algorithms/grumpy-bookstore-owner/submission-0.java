class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int windowMax = 0;
        int window = 0;
        int sastified = 0;
        int l = 0;
        for(int r = 0; r < n ; r++){
            if(grumpy[r] == 1){
                window+= customers[r];
            }else{
                sastified+= customers[r];
            }
            if(r - l + 1 > minutes){
                if(grumpy[l] == 1){
                    window-=customers[l];
                }
                l++;
            }
            windowMax = Math.max(windowMax,window);
        }
        return sastified + windowMax;
    }
}