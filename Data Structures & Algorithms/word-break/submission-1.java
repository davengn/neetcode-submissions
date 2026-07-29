class Solution {
    private Map<Integer, Boolean> cache;
    public boolean wordBreak(String s, List<String> wordDict) {
        cache = new HashMap<>();
        cache.put(s.length(), true);
        return dp(0, s, wordDict);
    }
    private boolean dp(int i, String s, List<String> wordDict) {
        if (cache.containsKey(i)) {
            return cache.get(i);
        }

        for (String w : wordDict) {
            if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                if (dp(i + w.length(), s, wordDict)) {
                    cache.put(i, true);
                    return true;
                }
            }
        }
        cache.put(i, false);

        return false;
    }
}
