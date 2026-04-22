class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxPro = 0;
        int right = 0;
        for (int i = 0; i < n-1; i++) {
            right=i+1;
            if(prices[i] < prices[right]){
                maxPro+= prices[right]-prices[i];
            }
        }
        return maxPro;
    }
}