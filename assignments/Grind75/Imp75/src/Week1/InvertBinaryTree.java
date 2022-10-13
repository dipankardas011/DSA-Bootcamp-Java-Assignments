package Week1;

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

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = invertTree(right);
            root.right = invertTree(left);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
