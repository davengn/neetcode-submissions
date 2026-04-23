class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> cache = new HashMap<>();

        int max = 0;
        int left = 0;
        int maxF = 0;
        for (int i = 0; i < s.length(); i++) {
            cache.put(s.charAt(i), cache.getOrDefault(s.charAt(i), 0) + 1);
            maxF = Math.max(maxF, cache.get(s.charAt(i)));
            while (i - left + 1 - maxF > k) {
                                cache.put(s.charAt(left), cache.get(s.charAt(left)) - 1);

                left++;
            }
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}
