class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> cache = new HashMap<>();

            int window = 0;
            int maxF = 0;
            for (int j = i; j < s.length(); j++) {
                cache.put(s.charAt(j), cache.getOrDefault(s.charAt(j), 0) + 1);
                maxF = Math.max(maxF, cache.get(s.charAt(j)));

                window = j - i + 1;
                if (window - maxF <= k) {
                    max = Math.max(window, max);
                }
            }
        }

        return max;
    }
}
