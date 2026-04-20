class Solution {
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) {
            encoded.append(s.length() + "#" + s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        char[] sArr = str.toCharArray();
        StringBuilder currentL = new StringBuilder();
        for (int i = 0; i < sArr.length; i++) {
            if(String.valueOf(sArr[i]).equals("#")){
                System.out.println(currentL.toString());
                int sl =  Integer.parseInt(currentL.toString()) ;
                String s = str.substring(i+1,i+sl+1);
                i = i+sl;
                result.add(s);
                currentL=new StringBuilder();
            }else{
                currentL.append(sArr[i]);
            }
            
        }
        return result;
    }
}
