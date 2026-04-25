class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length - 1;
        int right = n;
        int i = 0;
        while (i < right) {
            int sum = numbers[i] + numbers[right];
            if ( sum == target) {
                return new int[] {i +1, right+1};
            } else if (sum > target) {
                right--;
            } else {
                i++;
            }
        }
        return new int[] {};
    }
}
