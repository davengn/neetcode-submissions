class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();
        for (String s : strs) {
            int[] keys = new int[26];
            for(Character c : s.toCharArray()){
                int index = c - 'a';
                keys[index]+=1;
            }
            StringBuilder dictKey = new StringBuilder();
            for(int key : keys){
                dictKey.append(key).append("#");
            }
            if(dict.containsKey(dictKey.toString())){
                dict.get(dictKey.toString()).add(s);
            }else{
                dict.put(dictKey.toString(), new ArrayList<String>(List.of(s)));
            }
        } 
        return  new ArrayList<>(dict.values());
    }
}
