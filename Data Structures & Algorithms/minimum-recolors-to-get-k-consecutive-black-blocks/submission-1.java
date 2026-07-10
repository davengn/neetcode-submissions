class Solution {
    public int minimumRecolors(String blocks, int k) {
        int count_w = 0;
        int n = blocks.length();

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                count_w++;
            }
        }
        int res = count_w;
        for (int i = k; i < n; i++) {
            if (blocks.charAt(i - k) == 'W') {
                count_w--;
            }
            if (blocks.charAt(i) == 'W') {
                count_w++;
            }
            res = Math.min(res, count_w);
        }
        return res;
    }
}