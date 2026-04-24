class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrone(s.substring(0,left) + s.substring(left +1 ))
                    || isPalindrone(s.substring(0, right) + s.substring(right +1 ));
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean isPalindrone(String s) {
        int left = 0;
        int right = s.length() -1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}