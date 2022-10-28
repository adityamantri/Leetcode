class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min;
    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.offerFirst(val);
        if(min.isEmpty() || min.peekFirst() >= val){
            min.offerFirst(val);
        }        
    }
    
    public void pop() {
        int num = stack.pollFirst();
        if(num <= min.peekFirst()){
            min.pollFirst();
        }
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return min.peekFirst();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */