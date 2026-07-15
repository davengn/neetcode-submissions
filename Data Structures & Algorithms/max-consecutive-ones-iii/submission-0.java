class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int zeroCount = 0;
        int res = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[l] == 0) {
                    zeroCount--;
                }
                l++;
            }
            res = Math.max(res,r -l +1);
        }
        return res;
    }
}