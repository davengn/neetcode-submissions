class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int res = 0;
        Set<Character> cache = new HashSet<>();
        for(int r = 0; r < s.length(); r++ ){
            while(cache.contains(s.charAt(r))){
                cache.remove(s.charAt(l));
                l++;
            }
            cache.add(s.charAt(r));
            res = Math.max(r - l + 1, res);
        }
        return res;
    }
}
