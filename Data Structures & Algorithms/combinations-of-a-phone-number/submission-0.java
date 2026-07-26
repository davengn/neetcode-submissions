class Solution {
    String[] digitToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        StringBuilder com = new StringBuilder();
        backtrack(0,digits,com);
        return res;
    }
    private void backtrack(int i , String digits, StringBuilder com){
        if(com.length() >= digits.length()){
            res.add(com.toString());
            return;
        }
        String s = digitToChar[digits.charAt(i) - '0'];
        for(int j = 0; j < s.length(); j++){
            com.append(s.charAt(j));
            backtrack(i + 1,digits,com);
            com.deleteCharAt(com.length() -1);
        }
    }
}
