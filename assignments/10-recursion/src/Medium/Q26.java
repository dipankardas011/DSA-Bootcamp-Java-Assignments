package Medium;

import java.util.Iterator;
import java.util.Stack;

public class Q26 {

    /**
     * Its just like addtion of idata at the bottom not on the top
     * O(N)
     * @param stk
     * @param idata
     */
    private void addToBottom(Stack<Integer> stk, int idata) {
        if (stk.empty()) {
            stk.push(idata);
            return;
        }
        int x = stk.pop();
        addToBottom(stk, idata);
        stk.push(x);
    }

    public void ReverseStack(Stack<Integer> stk) {
        if (!stk.empty()) {
            int top = stk.pop();
            ReverseStack(stk);

            // call new function here we are ensuring that all the elements are in
            // resursion calls not in the stack so we can modify it
            addToBottom(stk, top);
        }
    }

    public static void main(String[] args) {
        Q26 o = new Q26();
        Stack<Integer> stk = new Stack<>();
        stk.push(4);
        stk.push(3);
        stk.push(2);
        stk.push(1);
        System.out.println("Top: "+stk.peek());
        System.out.println(stk);
        o.ReverseStack(stk);
        System.out.println("Top: "+stk.peek());
        System.out.println(stk);
    }
}