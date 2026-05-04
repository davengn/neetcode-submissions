class MyStack {
    private List<Integer> store ;
    private int size = 0;
    public MyStack() {
        this.store = new ArrayList<>();
    }
    
    public void push(int x) {
        store.add(x);
        size++;
    }
    
    public int pop() {
        int res = store.get(size-1);
        store.remove(size-1);
        size--;
        return res;
    }
    
    public int top() {
        return store.get(size-1);
    }
    
    public boolean empty() {
        return size ==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */