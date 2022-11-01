package Week2;

public class TreeNode {
    int val;
    Week2.TreeNode left;
    Week2.TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, Week2.TreeNode left, Week2.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
