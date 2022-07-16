package Medium;


import com.sun.source.tree.Tree;

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

public class Q15 {

    private void rootRightLeft(TreeNode root, int depth, List<Integer> list) {
        if (root != null) {
            if (list.size() == depth)
                list.add(root.val);
//            System.out.println(root.val + " " + depth);
            rootRightLeft(root.right, depth + 1, list);
            rootRightLeft(root.left, depth + 1, list);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        rootRightLeft(root, 0, res);

        return res;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right  = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.left.right.left  = new TreeNode(6);
        System.out.println(new Q15().rightSideView(root));
    }
}
