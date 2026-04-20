class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (dict.containsKey(sorted)) {
                dict.get(sorted).add(s);
            } else {
                dict.put(sorted, new ArrayList<String>(List.of(s)));
            }
        }
        return  new ArrayList<>(dict.values());
    }
}
