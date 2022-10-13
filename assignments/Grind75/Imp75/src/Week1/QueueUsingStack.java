package Week1;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> main;
    Stack<Integer> temp;

    public MyQueue() {
        main = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int x) {
        while (!main.isEmpty()) {
            temp.push(main.pop());
        }
        temp.push(x);
        while (!temp.isEmpty()) {
            main.push(temp.pop());
        }
    }

    public int pop() {
        return main.pop();
    }

    public int peek() {
        return main.peek();
    }

    public boolean empty() {
        return main.isEmpty();
    }
}
