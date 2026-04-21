class Solution {
    public int maxArea(int[] heights) {
        int maxContainer = 0;
        int right = heights.length - 1;
        int left = 0;
        while (left < right) {
            int minH = Math.min(heights[left], heights[right]);
            int container = minH * (right - left);
            maxContainer = Math.max(container, maxContainer);
            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxContainer;
    }
}
