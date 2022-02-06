package Medium;

import java.util.Stack;

/**
 * Input:  -3  <--- Top
 *         14
 *         18
 *         -5
 *         30
 *
 * Output: 30  <--- Top
 *         18
 *         14
 *         -3
 *         -5
 */
public class Q25 {

    private void insertInto(Stack<Integer> stk, int idata) {
        if (stk.empty() || stk.peek() < idata) { // top is largest
            stk.push(idata);
            return;
        }

        int top = stk.pop();
        insertInto(stk, idata);
        stk.push(top);
    }

    public void sortStack(Stack<Integer> stk) {
        if (!stk.isEmpty()) {
            int top = stk.pop();
            sortStack(stk);

            // in the last element
            insertInto(stk, top);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-5);
        stk.push(30);
        stk.push(18);
        stk.push(14);
        stk.push(-3);
        System.out.println(stk);

        new Q25().sortStack(stk);
        System.out.println(stk);
    }
}