class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int n = nums.length;
        int right = n -1;
        if(n == 1) return nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2; // pair is intact, single is to the right
            } else {
                right = mid; // pair is broken, single is at mid or left
            }
        }
        return nums[left];
    }
}