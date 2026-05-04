class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> prefix;

    public MinStack() {
        this.stack = new Stack<>();
        this.prefix = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (prefix.isEmpty() || val <= prefix.peek()) {
            prefix.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        int val  = stack.pop();

        if (prefix.peek() == val) {
            prefix.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return prefix.peek();
    }
}
