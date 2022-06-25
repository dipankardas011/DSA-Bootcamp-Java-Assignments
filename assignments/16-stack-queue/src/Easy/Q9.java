package Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Q9 {
    ArrayList<Integer> inOrder(Node xyz) {
        // Code
        ArrayList<Integer> res = new ArrayList<>();

        // L root R
        Stack<Node> stk = new Stack<>();
        Node root = xyz;
        while (!stk.isEmpty() || root != null) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.data);
            root = root.right;
        }
        return res;
    }
}
