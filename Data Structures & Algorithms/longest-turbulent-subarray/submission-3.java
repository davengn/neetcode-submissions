class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int l = 0;
        int max = 1;
        int previous = 0; // -1 if lower , 1 if higher
        int r = 1;
        while (r < arr.length) {
            if (arr[r - 1] < arr[r] && previous != -1) {
                max = Math.max(max, r - l + 1);
                previous = -1;
                r++;

            } else if (arr[r - 1] > arr[r] && previous != 1) {
                max = Math.max(max, r - l + 1);
                previous = 1;
                r++;
            } else {
                r = (arr[r] == arr[r - 1]) ? r + 1 : r;
                l = r - 1;
                previous = 0;
            }
        }
        return max;
    }
}