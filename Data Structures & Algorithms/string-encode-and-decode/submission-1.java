class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) {
            encoded.append(s.length()).append("#").append(s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i< str.length()){
            int pos = str.indexOf("#",i);
            int length = Integer.parseInt(str.substring(i,pos));
            String s = str.substring(pos+1,pos + length+1);
            result.add(s);
            i = pos + 1 + length;
        }
        return result;
    }
}
