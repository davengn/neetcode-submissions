class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int low = 0;
        int high = low + k - 1;
        int min = Integer.MAX_VALUE;
        while (high < n) {
            int count = 0;
            for (int i = low; i <= high; i++) {
                if (blocks.charAt(i) == 'W') {
                    count++;
                }
            }
            min = Math.min(min,count);
            low++;
            high++;
        }
        return min;
    }
}