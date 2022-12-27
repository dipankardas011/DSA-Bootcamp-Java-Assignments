package Week4;
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

public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        return util(root, null, null);
    }
//    used integer to avoid INT.MAX_VAL or MIN issues
    private boolean util(TreeNode root, Integer low, Integer high){
        if(root == null) return true;
        if(low != null && root.val <= low || high != null && root.val >= high)
            return false;
        return util(root.left, low, root.val) && util(root.right, root.val, high);
    }

    public static void main(String[] args) {

    }
}
