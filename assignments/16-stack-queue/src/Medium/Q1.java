package Medium;

import java.util.Stack;

class CustomStack {
    Stack<Integer> main;
    final int MAX_SIZE;
    public CustomStack(int maxSize) {
        main = new Stack<>();
        MAX_SIZE = maxSize;
    }

    public void push(int x) {
        if (main.size() == MAX_SIZE)
            return;
        main.push(x);
    }

    public int pop() {
        if (main.isEmpty())
            return -1;
        return main.pop();
    }

    public void increment(int k, int val) {
        Stack<Integer> temp = new Stack<>();

        if (main.size() < k) {

            while (!main.isEmpty()) {
                temp.push(main.pop() + val);
            }

            while (!temp.isEmpty())
                main.push(temp.pop());
        } else {
            int numberOfPops = main.size() - k;
            while (numberOfPops-- > 0) {
                temp.push(main.pop());
            }
            while (!main.isEmpty()) {
                temp.push(main.pop() + val);
            }

            while (!temp.isEmpty())
                main.push(temp.pop());
        }
    }
}
public class Q1 {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3); // Stack is Empty []
        customStack.push(1);                          // stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        System.out.println(customStack.pop());                            // return 2 --> Return top of the stack 2, stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.push(3);                          // stack becomes [1, 2, 3]
        customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
        customStack.increment(5, 100);                // stack becomes [101, 102, 103]
        customStack.increment(2, 100);                // stack becomes [201, 202, 103]
        System.out.println(customStack.pop());                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        System.out.println(customStack.pop());                            // return 202 --> Return top of the stack 102, stack becomes [201]
        System.out.println(customStack.pop());                            // return 201 --> Return top of the stack 101, stack becomes []
        System.out.println(customStack.pop());                            // return -1 --> Stack is empty return -1.
    }
}
