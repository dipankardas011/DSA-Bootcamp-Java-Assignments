package Easy;

import java.util.Stack;

class MyQueue {
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

public class Q12 {
    public static void main(String[] args) {
        MyQueue que = new MyQueue();
    }
}
