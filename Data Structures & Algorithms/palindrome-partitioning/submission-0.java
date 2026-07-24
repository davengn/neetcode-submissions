class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> subset = new ArrayList<>();
        backtrack(0,s,subset);
        return res;
    }
    private void backtrack(int i, String s,List<String> subset ){
        if(i >= s.length()){
            res.add(new ArrayList<>(subset));
            return;
        }
        for(int j = i ;j < s.length(); j++){
            if(isPalindrome(s,i,j)){
                subset.add(s.substring(i,j +1));
                backtrack(j+1,s,subset);
                subset.remove(subset.size() -1);
            }
        }
    }
    private boolean isPalindrome(String s, int l , int r) {

        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
