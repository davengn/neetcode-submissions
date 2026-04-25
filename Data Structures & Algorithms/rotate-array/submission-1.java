class Solution {
    public void rotate(int[] nums, int k) {
        int right = nums.length - 1;
        int left = 0;
        while(k > 0){
            int tmp = nums[right];
            for(int i = nums.length-1; i > left;i--){
                nums[i] = nums[i-1];
            }
            nums[left] = tmp;
            k--;
        }
    }
}