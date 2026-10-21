class MinStack {
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> prefixStack = new ArrayDeque<>();

    public MinStack() {
    }
    
    public void push(int val) {
        stack.push(val);
        if(prefixStack.isEmpty()) prefixStack.push(val);
        else prefixStack.push(Math.min(prefixStack.peek(), val));
    }
    
    public void pop() {
        stack.pop();
        prefixStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return prefixStack.peek();
    }
}
