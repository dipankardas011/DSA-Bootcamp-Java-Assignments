package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Q10 {
    ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();

        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            root = stk.pop();
            res.add(root.data);
            if (root.right!=null){
                stk.push(root.right);
            }
            if (root.left != null) {
                stk.push(root.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q10 o = new Q10();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(o.preOrder(root).toString());
    }
}
