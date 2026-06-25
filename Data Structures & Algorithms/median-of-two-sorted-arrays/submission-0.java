class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int last = m + n -1;
        int[] nums3 = new int[m + n];
        for (int k = 0; k < m; k++) {
            nums3[k] = nums1[k];
        }
        while (m > 0 && n > 0) {
            if(nums3[m-1] < nums2[n-1] ){
                nums3[last] = nums2[n-1];
                n--;
            }else{
                nums3[last] = nums3[m-1];
                m--;
            }
            last--;
        }

        while (n > 0) {
            nums3[last] = nums2[n -1];
            last--;
            n--;
        }
        boolean isOdd = nums3.length % 2 != 0;
        int mid = (nums3.length - 1) / 2;
        double median = 0;
        if (isOdd) {
            median = nums3[mid];
        } else {
            median = (double )(nums3[mid] + nums3[mid + 1]) / 2;
        }
        return median;
    }
}
