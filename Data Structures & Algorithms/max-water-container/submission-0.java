class Solution {
    public int maxArea(int[] heights) {
        int maxContainer = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int minH = Math.min(heights[i],heights[j]);
                int container = minH * (j-i);
                maxContainer = Math.max(container,maxContainer);
            }
        }
        return maxContainer;
    }
}
