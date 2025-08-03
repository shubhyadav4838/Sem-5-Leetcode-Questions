// Last updated: 3/8/2025, 11:59:25 pm
class MyQueue {
    int f;
    Stack <Integer> stack1;
    Stack <Integer> stack2;

    public MyQueue() {
        f=-1;
        stack1=new Stack<>();
        stack2=new Stack<>();
        
    }
    
    public void push(int x) {
        if(stack1.isEmpty()){
            f=x;
        }
        stack1.push(x);
        
    }
    
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
        
    }

    
    public int peek() {
        return empty()?-1:stack2.isEmpty() ? f:stack2.peek();
        
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();

        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */