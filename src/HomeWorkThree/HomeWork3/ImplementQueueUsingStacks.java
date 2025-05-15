package HomeWork3;
import java.util.Stack;

class MyQueue {
    Stack < Integer > input = new Stack < > ();
    Stack < Integer > output = new Stack < > ();
    public MyQueue() {
    }

    public void push(int x) {

        input.push(x);

    }

    public int pop() {
        if(output.isEmpty())
            while(!input.isEmpty()) {
                output.push(input.peek());
                input.pop();
            }
        int x = output.peek();
        output.pop();
        return x;
    }

    public int peek() {
        if(output.isEmpty())
            while(!input.isEmpty()) {
                output.push(input.peek());
                input.pop();
            }
        return output.peek();
    }

    public boolean empty() {
        return input.size()==0&&output.size()==0;
    }
}
