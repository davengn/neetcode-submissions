class Solution {
    public int calPoints(String[] operations) {
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String o : operations) {
            if (o.equals("+")) {
                int temp = stack.pop();
                int tsum = temp + stack.peek();
                stack.push(temp);
                stack.push(tsum);
                sum+=tsum;
            }else if( o.equals("C")){
                int temp = stack.pop();
                sum-=temp;
            }else if( o.equals("D")){
                int tsum =  stack.peek() * 2;
                stack.push(tsum);
                sum+=tsum;
            }
            else{
                int newEl = Integer.parseInt(o);
                stack.push(newEl);
                sum+=newEl;
            }
        }
        return sum;
    }
}