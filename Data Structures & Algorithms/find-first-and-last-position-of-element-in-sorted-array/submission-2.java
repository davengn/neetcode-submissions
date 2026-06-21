class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int start = -1;
        int end = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                start = mid;
                end = mid;
                if (mid > 0 && nums[mid] == nums[mid - 1]) {
                    int startMid = mid;
                    while (startMid > 0 && nums[startMid] == nums[startMid - 1]) {
                        startMid--;
                    }
                    start = startMid;
                }

                if (mid < n - 1 && nums[mid] == nums[mid + 1]) {
                    int endMid = mid;
                    while (endMid < n - 1 && nums[endMid] == nums[endMid + 1]) {
                        endMid++;
                    }
                    end = endMid;
                }
                return new int[] {start, end};
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[] {start, end};
    }
}