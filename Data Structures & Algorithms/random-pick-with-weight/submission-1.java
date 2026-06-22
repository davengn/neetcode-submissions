class Solution {
    int[] w;
    int[] prefixSum;
    int totalSum =0;
    public Solution(int[] w) {
        this.w = w;
        this.prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        int tmpSum = prefixSum[0];
        for (int i = 1; i < w.length; i++) {
            tmpSum += w[i];
            prefixSum[i] = tmpSum;
        }
        this.totalSum = tmpSum;
    }

    public int pickIndex() {
        Random rand = new Random();
        int target = rand.nextInt(totalSum) + 1; // range [1, totalSum]
        return binarySearch(prefixSum,target);
        
    }
    private int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
      
        while(left < right){
            int mid = left + (right - left) /2 ;
            if(nums[mid] >= target ){
                right = mid;
            }else{
                left = mid +1;
            }
        }
        return right;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */