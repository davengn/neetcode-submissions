class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int count = 1;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            minHeap.offer(new int[] {nums[i], i});
            maxHeap.offer(new int[] {nums[i], i});
      
            while (maxHeap.peek()[0] -  minHeap.peek()[0] > limit) {
                ++j;
                while (!maxHeap.isEmpty() && maxHeap.peek()[1] < j) {
                    maxHeap.poll();
                }
                while (!minHeap.isEmpty() && minHeap.peek()[1] < j) {
                    minHeap.poll();
                }
            }
            count = Math.max(count, i -j + 1);
        }
        return count;
    }
}