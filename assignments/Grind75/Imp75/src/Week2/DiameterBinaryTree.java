package Week2;

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
public class DiameterBinaryTree {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getRes(root);
        return max;
    }

    private int getRes(TreeNode root) {
        if (root == null)
            return 0;

        int noOfEdgesL = 0, noOfEdgesR = 0;
        noOfEdgesL = getRes(root.left);
        noOfEdgesR = getRes(root.right);

        max = Math.max(noOfEdgesL+noOfEdgesR, max); // to store the edges of left +right

        return 1+ Math.max(noOfEdgesL, noOfEdgesR); // return the depth of that node
    }
}
