class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            int n = Math.min(prefix.length(), strs[i].length());
            while (j < n) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                j++;
            }
                prefix = prefix.substring(0, j);

        }
        return prefix;
    }
}