class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int voteL = 0;
        int voteR = 0;
        int leftMajor = 0;
        int rightMajor = 0;
        for (int i = 0; i < n; i++) {
            if(leftMajor==nums[i]){
                voteL++;
            }else if(rightMajor ==nums[i]){
                voteR++;
            }else if(voteL == 0){
                 voteL++;
                leftMajor=nums[i];
            }else if(voteR ==0){
                 voteL++;
                rightMajor=nums[i];
            }else{
                voteL--;
                voteR--;
            }
        }
          voteL = voteR = 0;
        for (int num : nums) {
            if (num == leftMajor) {
                voteL++;
            } else if (num == rightMajor) {
                voteR++;
            }
        }
         List<Integer> res = new ArrayList<>();
        if (voteL > n / 3) res.add(leftMajor);
        if (voteR > n / 3) res.add(rightMajor);
        return res;
    }
}