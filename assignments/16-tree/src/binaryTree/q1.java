import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class q1 {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            List<Integer> abc = new ArrayList<>();
            abc.addAll(inorderTraversal(root.left));
            abc.add(root.val);
            abc.addAll(inorderTraversal(root.right));
            return abc;
        }else {
            return new ArrayList<>();
        }
    }

}
