class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int windowSum = 0;
        int count =0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        if(windowSum >= threshold * k){
            count++;
        }
        for (int i = k; i < arr.length; i++) {
            windowSum -= arr[i-k];
            windowSum+= arr[i];
            if(windowSum >= threshold * k){
                count++;
            }
        }
        return count;
    }
}