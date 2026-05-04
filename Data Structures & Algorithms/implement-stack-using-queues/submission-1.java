
class MyStack {
    private final List<Integer> store;

    public MyStack() {
        this.store = new ArrayList<>();
    }
    
    public void push(int x) {
        store.add(x); // O(1) amortized
    }
    
    public int pop() {
        if (store.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return store.remove(store.size() - 1); // O(1)
    }
    
    public int top() {
        if (store.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return store.get(store.size() - 1); // O(1)
    }
    
    public boolean empty() {
        return store.isEmpty(); // O(1)
    }
}