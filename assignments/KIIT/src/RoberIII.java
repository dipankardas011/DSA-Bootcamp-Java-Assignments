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

public class RoberIII {
    public int rob(TreeNode root) {
        int [] maxSum = robHelper(root);
        return Math.max(maxSum[0],maxSum[1]);
    }

    public int[] robHelper(TreeNode root){
        if(root == null)
            return new int[2];
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        int[] currNode = new int[2];
        currNode[0] = root.val + left[1] + right[1];
        currNode[1] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        return currNode;
    }
}

