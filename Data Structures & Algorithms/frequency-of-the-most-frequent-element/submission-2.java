class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = left + 1;
        int n = nums.length;
        int max = 1;
        int currentSum = nums[left];
        while (right < n) {
            currentSum += nums[right];
            while ((long) nums[right] * (right - left + 1) - currentSum > k) {
                currentSum -= nums[left];
                left++;
            }
            max = Math.max(right - left + 1, max);
            right++;
        }
        return max;
    }
}