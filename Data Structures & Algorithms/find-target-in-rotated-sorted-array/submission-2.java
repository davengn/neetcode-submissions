class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]){
                left = mid +1;
            }else {
                right = mid;
            }
        }
        int r1 = binarySearch(0,left-1, nums,target);
        int r2 = binarySearch(left,nums.length-1, nums,target);

        return Math.max(r1,r2);
    }
    private int binarySearch(int left, int right, int[] nums , int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
