class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = 0;
        int r = s1.length() - 1;
        StringBuilder s1KeyString = new StringBuilder();
        int[] s1Key = new int[26];
        for (char c : s1.toCharArray()) {
            int index = c - 'a';
            s1Key[index]++;
        }
        for (int k : s1Key) {
            s1KeyString.append(k);
            s1KeyString.append("#");
        }
        System.out.println(s1KeyString.toString());
        while (r < s2.length()) {
            String sub = s2.substring(l, r +1);
            int[] key = new int[26];
            StringBuilder keyString = new StringBuilder();
            for (char c : sub.toCharArray()) {
                int index = c - 'a';
                key[index] +=1;
            }
            for (int k : key) {
                keyString.append(k);
                keyString.append("#");
            }
            System.out.println(keyString.toString());

            if (keyString.toString().equals(s1KeyString.toString())) {
                return true;
            }
            l++;
            r++;
        }
        return false;
    }
}
