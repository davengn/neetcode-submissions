class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> cache = new HashSet<>();
        int l = 0;
        int r = 0;
        int max = 0;
        while (r < s.length()) {
            while (cache.contains(s.charAt(r))) {
                cache.remove(s.charAt(l));
                l++;
            }

            cache.add(s.charAt(r));
            r++;

            max = Math.max(max, r - l);
        }

        return max;
    }
}
