package Easy;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q7 {
    Queue<Integer> reverseKele(Queue<Integer> inp, int K) {
        Stack<Integer> stk = new Stack<>();
        while (K-- > 0)
            stk.push(inp.poll());

        Queue<Integer> que = new LinkedList<>();
        while (!stk.isEmpty())
            que.add(stk.pop());

        while (!inp.isEmpty())
            que.add(inp.poll());
        return que;
    }

    public static void main(String[] args) {
        Queue<Integer> arr = new LinkedList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println(arr.toString());
        Queue<Integer> res = new Q7().reverseKele(arr, 3);
        System.out.println(res.toString());
    }
}
