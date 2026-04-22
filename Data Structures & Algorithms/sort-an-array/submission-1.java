class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int m = l + (r - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        merge(nums, m, l, r);
    }
    private void merge(int nums[], int m, int l, int r) {
        int[] lNums = new int[m - l + 1];
        int[] rNums = new int[r - m];
        for (int i = 0; i < lNums.length; ++i) {
            lNums[i] = nums[i + l];
        }
        for (int i = 0; i < rNums.length; ++i) {
            rNums[i] = nums[i + m +1];
        }
        int k = l;
        int i = 0;
        int j = 0;
        while (i < lNums.length && j < rNums.length) {
            if (lNums[i] <= rNums[j]) {
                nums[k] = lNums[i];
                i++;
            } else {
                nums[k] = rNums[j];
                j++;
            }

            k++;
        }
        while (i < lNums.length) {
            nums[k] = lNums[i];
            k++;
            i++;
        }
        while (j < rNums.length) {
            nums[k] = rNums[j];
            k++;
            j++;
        }
    }
}