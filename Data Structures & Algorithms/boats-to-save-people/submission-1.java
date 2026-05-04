class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int result = 0;
        int right = n -1;
        int left = 0;
        Arrays.sort(people);
        while(left <= right){
            int remain = limit - people[right--];
            result++;
            if(left <= right && remain >= people[left]){
                left++;
            }
        }
        return result;
    }
}