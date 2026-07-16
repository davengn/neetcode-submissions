class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty())
            return "";
        Map<Character, Integer> freqT = new HashMap<>();

        for (char c : t.toCharArray()) {
            int count = freqT.getOrDefault(c, 0);
            freqT.put(c, count + 1);
        }
        int need = freqT.size();
        int have = 0;
        int l = 0;
        Map<Character, Integer> window = new HashMap<>();
        int[] res = new int[] {-1, -1};
        int resLen = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (freqT.containsKey(c) && freqT.get(c) == window.get(c)) {
                have++;
            }
            while (have == need) {
                char d = s.charAt(l);
                window.put(d, window.get(d) - 1);
                if (freqT.containsKey(d) && window.get(d) < freqT.get(d)) {
                    have--;
                }
                if (r - l + 1 < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
