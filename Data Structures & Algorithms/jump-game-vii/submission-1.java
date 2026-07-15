class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        queue.add(0);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int min = Math.max(last + 1 , index + minJump);
            int max =  Math.min( index + maxJump +1, s.length());
            for(int i = min ; i < max ; i++){
                if(s.charAt(i) == '0'){
                    queue.add(i);
                    if(i == s.length() -1){
                        return true;
                    }
                }
            }
            last = index + maxJump;
        }
        return false;
    }
}