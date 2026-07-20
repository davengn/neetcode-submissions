class Solution {
    public int scoreOfString(String s) {
        int n = s.length();
        int prev = (int) s.charAt(n-1);
        int sum = 0;
        for(int i = n -1; i >= 0; i--){
            int ascii = (int) s.charAt(i); 
            sum += Math.abs(prev - ascii);
            prev = ascii;
        }
        return sum;
    }
}