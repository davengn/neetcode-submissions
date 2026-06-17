class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
                int n = word.length(), m = abbr.length();
        int i = 0;
        int j = 0;
        while(i < n && j <m){
            if(abbr.charAt(j) == '0'){
                return false;
            }
            else if(Character.isLetter(abbr.charAt(j))){
                if(word.charAt(i) != abbr.charAt(j)){
                    return false;
                }
                i++;
                j++;
            }else if(Character.isDigit(abbr.charAt(j))){
                int startJ = j;
                while(j< m && Character.isDigit(abbr.charAt(j)) ){
                    j++;
                }
                int digit = Integer.parseInt(abbr.substring(startJ,j));
                i = i + digit;
            }
        }
        return i == n && j == m;
    }
}