class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> rpn = new Stack<>();
        for (String t : tokens) {
            if (t.equals("+")) {
                rpn.push(rpn.pop() + rpn.pop());
            } else if (t.equals("-")) {
                   int val1=  rpn.pop();
                int val2= rpn.pop();
                rpn.push(val2- val1);
            } else if (t.equals("*")) {
                rpn.push(rpn.pop() * rpn.pop());
            } else if (t.equals("/")) {
                   int val1=  rpn.pop();
                int val2= rpn.pop();
                rpn.push(val2 / val1);
            } else {
                rpn.push(Integer.parseInt(t));
            }
        }
        return rpn.peek();
    }
}
